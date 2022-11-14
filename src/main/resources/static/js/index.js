let a = document.getElementsByTagName("a");
let page = document.querySelectorAll(".page")
for (let i = 0; i < a.length - 1; i++) {
    a[i].addEventListener('click', function() {
        console.log(i);
        page[i].style.display = 'block';
        if (i === 2) {
            page[i].style.display = 'flex';
        }
        for (let j = 0; j < page.length; j++) {
            if (i !== j) {
                page[j].style.display = 'none';
            }
        }
    })
}