const btnChooseStrore = document.querySelectorAll(".btn-choose__store");
const formChooseStore = document.getElementById("chooseStore");
const valueIdStore = document.querySelectorAll(".flag-idStore");
let storeId;
const urlBook = window.location.href;
const arrUrl = urlBook.split("&");
btnChooseStrore.forEach((btn, index) => {
    btn.onclick = (e) => {
        storeId = valueIdStore[index].value;
        e.preventDefault();
        formChooseStore.action = `${arrUrl[0]}&storeId=${storeId}&step=0`;
        formChooseStore.submit();
    }
})