const replyLayout = (() => {
    const showList = async (replyListData) => {
        const replies = replyListData.replies;
        const pagination = replyListData.pagination;
        const noReply = document.getElementById("no-reply");
        const repliesWrap = document.getElementById("replies-wrap");
        const pageWrap = document.getElementById("page-wrap");

        if(replies.length === 0){
            repliesWrap.style.display = "none";
            pageWrap.style.display = "none"
            noReply.style.display = "block";
        }else {
            noReply.style.display = "none"
            repliesWrap.style.display = "block";
            pageWrap.style.display = "block"

            let text = ``;

            replies.forEach(({id, replyContent, memberName, memberId, createdDate}) => {
                text += `
                    <tr class="reply-${id}">
                        <td>${id}</td>
                        <td>${replyContent}</td>
                        <td>${memberName}</td>
                        <td>${timeForToday(createdDate)}</td>
                `
                if(member !== null && member.id === memberId) {
                    text += `
                            <td><a class="go-update" href="${id}">수정</a></td>
                            <td style="display:none;"><a class="update" href="${id}">수정 완료</a></td>
                            <td><a class="delete" href="${id}">삭제</a></td>
                            `
                }
                text += `
                    </tr>
                `
            });

            repliesWrap.innerHTML = text;

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
    }
    return {showList: showList};
})();