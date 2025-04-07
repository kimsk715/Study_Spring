const postLayout = (() => {
    const showList = async (postListData) => {
        const tbody = document.querySelector("#posts-wrap tbody");
        const pageWrap = document.getElementById("page-wrap");
        const pagination = postListData.pagination;
        let text = ``;
        postListData.posts.forEach((post) => {
            text += `
                <tr>
                    <td>${post.id}</td>
                    <td><a href="/post/read?id=${post.id}">${post.postTitle}</a></td>
                    <td>${post.memberName}</td>
                    <td>${post.postReadCount}</td>
                    <td>${timeForToday(post.createdDate)}</td>
                </tr>
            `;
        })
        tbody.innerHTML = text;

        text = ``;
        if(pagination.prev){
            text += `<button class="page-button" id="${pagination.startPage - 1}">이전</button>`
        }
        for(let i=pagination.startPage; i<=pagination.endPage; i++){
            if(pagination.page === i){
                text += `<button class="on" id="${i}">${i}</button>`
                continue;
            }
            text += `<button class="page-button" id="${i}">${i}</button>`
        }
        if(pagination.next){
            text += `<button class="page-button" id="${pagination.endPage + 1}">다음</button>`
        }
        pageWrap.innerHTML = text;

    }

    return {showList: showList};
})();








