// Get the modal
var modal = document.getElementById('myModal');
// Get the image and insert it inside the modal
var modalImg = document.getElementById("img01");

function showImage(e){

    modal.style.display = "block";
    modalImg.src = e.src;
}

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}