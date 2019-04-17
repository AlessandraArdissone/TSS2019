import TagService from "./js/TagService.js";
import Tabella from "./js/Tabella.js";

class App {
    constructor() {

        this.onCreate = this.onCreate.bind(this);
        this.onUpdate = this.onUpdate.bind(this);
        this.onDelete = this.onDelete.bind(this);
        this.onSave = this.onSave.bind(this);

        this.operationReq = '';
        this.tag = document.querySelector("#tag");
        this.tipo = document.querySelector("#tipo");
        this.bSave = document.querySelector("#b_modTag");
        this.bSave.onclick = this.onSave;
        this.service = new TagService();
        this.tb = new Tabella({
            titolo: "Elenco TAGS",
            service: this.service,
            idTabella: "tblTags",
            classeTabella: "pure-table table-select",
            contenitore: "#contenitore",
            page: 6,
            callbackCreate: this.onCreate,
            callbackUpdate: this.onUpdate,
            callbackDelete: this.onDelete
        });

    }

    onCreate() {
        this.operationReq = "CREATE";
        this.tag.value = "";
        this.tipo.value = "";
    }

    onUpdate(url) {
        this.operationReq = "UPDATE";
        this.url = url;
        this.service.find(url).then(json => {
            this.tag.value = json.tag;
            this.tipo.value = json.tipo;
        });
    }

    onDelete(url) {
        this.operationReq = "DELETE";
        this.service.delete(url);
        this.tb.reloadData();
    }

    onSave() {
        if (this.operationReq === "CREATE") {
            this.service.create({
                tag: this.tag.value,
                tipo: this.tipo.value
            });
        } else {
            this.service.update(this.url, {
                tag: this.tag.value,
                tipo: this.tipo.value
            });
        }
        this.tb.reloadData();
    }
}

new App();



