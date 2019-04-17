import {html, render} from "./../node_modules/lit-html/lit-html.js"
import Paginator from "./Paginator.js"

        /**
         titolo;
         service;
         idTabella;
         classeTabella;
         contenitore;
         page
         */

export default class Tabella1 {

    constructor(properties) {
        this.prop = properties;
        this.bindings();
        this.el = document.querySelector(this.prop.contenitore);
        this.rowSelected = null;
        this.loadData();
    }

    bindings() {
        this.onCreate = this.onCreate.bind(this);
        this.onUpdate = this.onUpdate.bind(this);
        this.onDelete = this.onDelete.bind(this);
        this.onPaginatorClick = this.onPaginatorClick.bind(this);
        this.onRowClick = this.onRowClick.bind(this);
    }
    
    loadData() {
        this.prop.service.all(0, this.prop.page)
                .then(json => {
                    this.data = json.data;
                    this.count = json.count;
                    this.readFields();
                    this.el = document.querySelector(this.prop.contenitore);
                    render(this.createView(), this.el);
                });
    }

    createView(json) {
        return html `
        <table id="${this.prop.idTabella}" class="${this.prop.classeTabella}">
            <caption>${this.prop.titolo}</caption>
            <thead>
                <tr>${this.fields.map(name => html`<th>${name}</th>`)}</tr>
            </thead>
            <tbody>
                ${this.data.map(v => this.row(v))}
            </tbody>
            <tfoot>
                <tr>
                    <td colSpan="${this.fields.length}">

                    </td>
                </tr>
                <tr>
                    <td colSpan="${this.fields.length}">
                        <button id="btnCreate" @click=${this.onCreate}>Crea</button>
                        <button id="btnUpdate" @onclick=${this.onUpdate}>Aggiorna</button>
                        <button id="btnDelete" @onclick=${this.onDelete}>Elimina</button>
                    </td>
                </tr>
            </tfoot>
        </table>`
    }

    readFields() {
        const [first] = this.data;
        this.fields = Reflect.ownKeys(first).filter(v => v !== 'url');
    }

    row(rowData) {
        return html`
            <tr @click=${this.onRowClick}>${this.fields
                .map(v => Reflect.get(rowData, v))
                .map(v => html`<td>${v}</td>`)}
            </tr>`
    }

    createPaginator(col) {
        this.paginator = new Paginator({
            page: this.prop.page,
            count: this.count,
            callback: this.onPaginatorClick
        });
        col.appendChild(this.paginator.first);
        col.appendChild(this.paginator.prev);
        col.appendChild(this.paginator.next);
        col.appendChild(this.paginator.last);
    }

    /*
     * events
     */

    onRowClick(e) {
        console.log("onRowClick");
        if (this.rowSelected !== null) {
            this.rowSelected.classList.toggle('row-select');
        }
        this.rowSelected = e.target.parentElement;
        this.rowSelected.classList.toggle('row-select');
    }

    onPaginatorClick() {
        this.reloadData();
    }

    onCreate() {
        console.log("onCreate")
        this.prop.callbackCreate();
    }

    onUpdate() {
        this.prop.callbackUpdate(this.rowSelected.getAttribute('data'));
    }

    onDelete() {
        this.prop.callbackDelete(this.rowSelected.getAttribute('data'));
    }

    reloadData() {
        this.prop.service.all((this.paginator.current - 1) * this.paginator.page, this.paginator.page)
                .then(json => {
                    this.data = json.data;
                    this.tbody.innerHTML = "";
                    this.createBody();
                });
    }
}


