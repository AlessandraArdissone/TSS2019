/*
 * page
 * count
 * callback
 */

export default class Paginator {
    constructor(properties) {
        this.prop = properties;
        this.current = 1;
        this.page = this.prop.page;
        this.count = this.prop.count;
        this.lastPage = this._lastPage();
        
        this._onFirst = this._onFirst.bind(this);
        this._onPrev = this._onPrev.bind(this);
        this._onNext = this._onNext.bind(this);
        this._onLast = this._onLast.bind(this);
        this._checkButtons = this._checkButtons.bind(this);
        
        this._create();
        this._checkButtons();
    }

    _lastPage(){
        let p = Math.floor(this.count / this.page);
        return this.count % this.page !== 0 ? p + 1 : p;
    }
    _create() {
        this.first = this._createButton("btnFirst", "First", this._onFirst);
        this.prev = this._createButton("btnFirst", "Prev", this._onPrev);
        this.next = this._createButton("btnFirst", "Next", this._onNext);
        this.last = this._createButton("btnFirst", "Last", this._onLast);
    }

    _createButton(id, label, clickHandler) {
        const b = document.createElement("button");
        b.id = id;
        b.innerText = label;
        b.classList.add("pure-button")
        b.addEventListener("click", clickHandler);
        b.addEventListener("click", this._checkButtons);
        if (this.prop.callback) {
            b.addEventListener("click", this.prop.callback);
        }
        return b;
    }

    _checkButtons() {
        this.first.classList.toggle("pure-button-disabled",this.current == 1);
        this.prev.classList.toggle("pure-button-disabled",this.current == 1);
        this.next.classList.toggle("pure-button-disabled",this.current == this.lastPage);
        this.last.classList.toggle("pure-button-disabled",this.current == this.lastPage);
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


