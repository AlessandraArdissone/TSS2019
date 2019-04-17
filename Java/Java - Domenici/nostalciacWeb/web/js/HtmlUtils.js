function createButton(id, label, clickHandler) {
    const b = document.createElement("button");
    b.id = id;
    b.innerText = label;
    b.classList.add("pure-button")
    b.addEventListener("click", clickHandler);
    return b;
}

export {createButton}
