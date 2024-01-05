document.addEventListener("DOMContentLoaded",function(event){
    var inputSearch = document.getElementById("keyword");
    inputSearch.onkeydown = function(event){
        if(event.keyCode==13){
            loadVideo(this.value);
        }
    }
    loadVideo("Đen Vâu");
});
//Get the model
var model = document.getElementById('myModel');
//Get the <span> element
var span = document.getElementsByClassName("close")[0];
var videoFrame = document.getElementById("video-frame");

span.onclick = function(){
    closeVideo();
}
window.onclick = function(event){
    if(event.target ==model){
        closeVideo();
    }
}

function loadVideo(keyword){
    var YOUTUBE_API = "https://content.googleapis.com/youtube/v3/search?q=" + keyword + "&type=video&maxResults=20&part=snippet&key=AIzaSyBJDY18Bs1vi803K9c1jHmKyaSpEY7RWEw";
    console.log(YOUTUBE_API);
    var xhr = new XMLHttpRequest();
    xhr.open("GET",YOUTUBE_API,true);//goi len youtube
    xhr.onreadystatechange = function(){
        if(this.readyState == 4 && this.status == 200){
            //Parser ket tra ve kieu json
            var responseJson = JSON.parse(this.responseText);//phan tich tai lieu, json, xml.
            var htmlContent = "";
            for(var i = 0; i < responseJson.items.length; i++){
                if(responseJson.items[i].id.kind == 'youtube#channel'){
                    continue;
                }
                var videoId = responseJson.items[i].id.videoId;
                var videoTitle = responseJson.items[i].snippet.title;
                var videoDescription = responseJson.items[i].snippet.description;
                var videoThumbnail = responseJson.items[i].snippet.thumbnails.medium.url;
                htmlContent += '<div class="video" onclick="showVideo(\'' + videoId + '\')">'
                htmlContent += '<img src="' + videoThumbnail + '">'
                htmlContent += '<div class ="title">'+videoTitle+ '</div>'
                htmlContent += '</div>'
            }
            document.getElementById("list-video").innerHTML = htmlContent;
        }else if(this.readyState == 4){
            console.log("Load fails");
        }
        
    };
    xhr.send();
}
function closeVideo(){
    model.style.display = "none";
    videoFrame.src = "";
}
function showVideo(videoId){
    videoFrame.src = "https://www.youtube.com/embed/"+ videoId +"?autoplay=1";
    setTimeout(function(){
        model.style.display = "block";
    },300);
}
