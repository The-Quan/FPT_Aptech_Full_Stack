document.addEventListener('DOMContentLoaded', function(){
    const searchIcon = document.getElementById('search-icon1');
    const searchForm = document.getElementById('search-form');

    searchIcon.addEventListener('click', function(){
        if(searchForm.style.display === 'block'){
            searchForm.style.display = 'none';
        }else{
            searchForm.style.display = 'block';
        }
    });

    //click out
    document.addEventListener('click', function(event){
        if(event.target !== searchIcon && !searchForm.contains(event.target)){
           searchForm.style.display = 'none';
        }
    })
});