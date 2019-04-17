/*
 * page
 * count
 * callback
 * 
 */

export default class Paginator {
    constructor(properties) {
        this.prop = properties;
        this.bindings();
        this.current = 1;
        this.page = this.prop.page;
        this.count = this.prop.count;
        this.lastPage = this.lastPage();
        this.createView();
        this._checkButtons();
    }

    bindings() {
        this._onFirst = this._onFirst.bind(this);
        this._onPrev = this._onPrev.bind(this);
        this._onNext = this._onNext.bind(this);
        this._onLast = this._onLast.bind(this);
        this._checkButtons = this._checkButtons.bind(this);
    }
    
    lastPage() {
        let p = Math.floor(this.count / this.page);
        return this.count % this.page !== 0 ? p + 1 : p;
    }
    
    createView() {
        return html`
            <button id="btnFirst" @click=${this.onFirst} @click=${this.checkButtons} @click=${this.prop.callback}>First</button>
            <button id="btnPrev" @onclick=${this.onPrev}>Prev</button>
            <button id="btnNext" @onclick=${this.onNext}>Next</button>
            <button id="btnLast" @onclick=${this.onLast}>Last</button>
        `
    }

    _createButton(id, label, clickHandler) {
        const b = document.createElement("button");
        b.id = id;
        b.innerText = label;
        b.classList.add("pure-button")
        b.addEventListener("click", clickHandler);
        b.addEventListener("click", this.checkButtons);
        if (this.prop.callback) {
            b.addEventListener("click", this.prop.callback);
        }
        return b;
    }

    _checkButtons() {
        this.first.classList.toggle("pure-button-disabled", this.current == 1);
        this.prev.classList.toggle("pure-button-disabled", this.current == 1);
        this.next.classList.toggle("pure-button-disabled", this.current == this.lastPage);
        this.last.classList.toggle("pure-button-disabled", this.current == this.lastPage);
    }

    _onFirst() {
        this.current = 1;
    }

    _onPrev(e) {
        this.current--;
    }

    _onNext(e) {
        this.current++;
    }

    _onLast(e) {
        this.current = this.lastPage;
    }
}


