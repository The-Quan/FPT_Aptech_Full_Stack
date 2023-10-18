document.addEventListener("DOMContentLoaded", function(event) {
    var inputSearch = document.getElementById("kyword");
    inputSearch.onkeydown = function(event){
        if (event.keyCode==13){
            loadVideo(this.value);
        }
    }
    loadVideo("Đen vâu");
});

var modal = document.getElementById('myModal');

// get the <span> element that closes the modal
var span = document.getElementByClassName('close')[0];
var videoFrame = document.getElementById("video-frame");

span.onclick = function(){
    closeVideo();
}
window.onclick = function(event) {
    if (event.target == modal){
        closeVideo();
    }
}
function loadVideo(keyword) {
    var YOUTUBE_AIP=
}