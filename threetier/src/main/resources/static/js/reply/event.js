const writeButton = document.getElementById("write-button");
const repliesWrap = document.getElementById("replies-wrap");
const pageWrap = document.getElementById("page-wrap");

replyService.getList(post.id, replyLayout.showList);

writeButton.addEventListener("click", async (e) => {
    const replyContent = document.getElementById("reply-content");
    await replyService.write({postId: post.id, memberId: member.id, replyContent: replyContent.value});
    replyContent.value = "";
    replyService.getList(post.id, replyLayout.showList);
});

pageWrap.addEventListener("click", (e) => {
    if(e.target.classList.contains("page-button")){
        const page = e.target.id;
        replyService.getList(post.id, replyLayout.showList, page);
    }
});

repliesWrap.addEventListener("click", async (e) => {
    e.preventDefault();
    if(e.target.classList.contains("go-update")){
        e.target.parentElement.style.display = "none";
        e.target.parentElement.nextElementSibling.style.display = "block";
        const replyId = e.target.getAttribute("href");
        const textarea = document.createElement("textarea");
        const targetTd = e.target.parentElement.parentElement.children[1];
        textarea.value = targetTd.innerText;
        textarea.id = replyId;
        targetTd.innerHTML = "";
        targetTd.appendChild(textarea);

    }else if(e.target.classList.contains("update")){
        e.target.parentElement.style.display = "none";
        e.target.parentElement.previousElementSibling.style.display = "block";
        const replyId = e.target.getAttribute("href");
        const replyContent = document.getElementById(`${replyId}`);
        await replyService.update({id: replyId, replyContent: replyContent.value});
        await replyService.getList(post.id, replyLayout.showList);

    }else if(e.target.classList.contains("delete")){
        const replyId = e.target.getAttribute("href")
        await replyService.remove(replyId);
        await replyService.getList(post.id, replyLayout.showList);
    }
});

















