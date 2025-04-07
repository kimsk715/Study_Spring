const pageWrap = document.getElementById("page-wrap");
const orders = document.querySelectorAll("a.order");
const searchCategories = document.querySelectorAll("#search-wrap div");
const keywordInput = document.querySelector("#search-wrap input[name=keyword]");

postService.getList(postLayout.showList);

pageWrap.addEventListener("click", (e) => {
    if(e.target.className.includes("page-button")){
        postService.getList(postLayout.showList, {page: e.target.id});
    }
});

orders.forEach((order) => {
    order.addEventListener("click", (e) => {
        e.preventDefault();
        const orderType = e.target.getAttribute("href");
        const categoryDatas = [];
        const categories = document.querySelectorAll("#search-wrap div.on");
        categories.forEach((category) => {
            categoryDatas.push(category.id);
        });
        const param = {orderType: orderType, search: {category: categoryDatas}}
        const keyword = keywordInput.value;
        if(keyword){
            param.search.keyword = keyword;
        }
        postService.getList(postLayout.showList, param);
        orders.forEach((order) => {order.classList.toggle("on")});
    });
});


searchCategories.forEach((searchCategory) => {
    searchCategory.addEventListener("click", (e) => {
        e.target.classList.toggle("on");
        const keyword = keywordInput.value;
        const categoryDatas = [];
        const categories = document.querySelectorAll("#search-wrap div.on");
        categories.forEach((category) => {
            categoryDatas.push(category.id);
        });
        orders[0].classList.add("on");
        orders[1].classList.remove("on");

        const param = {search: {category: categoryDatas}}
        if(keyword){
            param.search.keyword = keyword;
        }
        postService.getList(postLayout.showList, param);
    })
})

keywordInput.addEventListener("keyup", (e) => {
    if(e.key === 'Enter'){
        const keyword = e.target.value;
        if(keyword){
            orders[0].classList.add("on");
            orders[1].classList.remove("on");
            const categoryDatas = [];
            const categories = document.querySelectorAll("#search-wrap div.on");
            categories.forEach((category) => {
                categoryDatas.push(category.id);
            });
            postService.getList(postLayout.showList, {search: {category: categoryDatas, keyword: keyword}});
        }
    }
})











