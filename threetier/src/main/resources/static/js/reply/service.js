const replyService = (() => {
    // 목록
    const getList = async (postId, callback, page=1) => {
        const response = await fetch(`/replies/${postId}/${page}`);
        const replyListData = await response.json();
        if(callback){
            callback(replyListData);
        }
    }

    // 추가
    const write = async (reply) => {
        await fetch("/replies/write", {
            method: "post",
            body: JSON.stringify(reply),
            headers: {
                "Content-Type": "application/json;charset=utf-8"
            }
        });
    }

    // 수정
    const update = async (reply) => {
        await fetch("/replies/update", {
            method: "put",
            body: JSON.stringify(reply),
            headers: {
                "Content-Type": "application/json;charset=utf-8"
            }
        });
    }
    
    // 삭제
    const remove = async (id) => {
        await fetch(`/replies/${id}`, {
            method: "delete"
        });
    }

    return {getList: getList, write: write, update: update, remove: remove};
})();