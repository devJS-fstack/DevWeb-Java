const changeBook = document.querySelector('.change-book');
const cancelBook = document.querySelector('.cancel-book');
const cancelForm = document.getElementById('cancelBookForm');
changeBook.onclick = (e) => {
    e.preventDefault();
    const answer = confirm('Anh có chắc chắn muốn đổi lịch không ạ?');
    if (answer) {
        location.href = changeBook.href;
    }
}
cancelBook.onclick = (e) => {
    e.preventDefault();
    const answer = confirm('Anh có chắc chắn muốn hủy lịch không ạ?');
    if (answer) {
        cancelForm.submit();
    }	
}