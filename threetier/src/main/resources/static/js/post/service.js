const postService = (() => {

    // 게시글 목록
    const getList = async (callback, param={}) => {
        let page = param.page || 1;
        let orderType = param.orderType || 'recent';
        let search = param.search;
        let keyword = "";
        let category = "";
        if(search){
            keyword = search.keyword
            category = search.category
        }
        let path = `/posts/list?page=${page}&order=${orderType}`;
        if(category.length != 0){
            path += `&`
            category.forEach((data) => {
                path += `categories=${data}&`;
            })
        }
        if(keyword){
            path += `&keyword=${keyword}`
        }
        const response = await fetch(path)
        const postListData = await response.json();
        if(callback){
            callback(postListData);
        }
    }



    return {getList: getList};
})();