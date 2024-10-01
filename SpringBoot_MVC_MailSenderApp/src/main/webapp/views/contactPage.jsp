<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Page</title>
<style type="text/css">

function addClass() {
  document.body.classList.add("sent");
}

sendLetter.addEventListener("click", addClass);


@use postcss-nested;
@import url(https://fonts.googleapis.com/css?family=Dancing+Script:400,700);
* {
  box-sizing: border-box;
}
body {
  margin: 0;
  padding: 0;
  background-color: #c8e7d8;
  color: #4e5e72;
  text-align: center;
  font-family: monospace;
  overflow: hidden;
}
h1, p {
  margin: 0;
  padding: 0;
}
h1 {
  font-size: 2rem;
  font-family: 'Dancing Script';
}
small {
  display: block;
  padding: 1rem 0;
  font-size: 0.8rem;
  transition: opacity 0.33s;
}
textarea, input, button {
  line-height: 1.5rem;
  border: 0;
  outline: none;
  font-family: inherit;
  appearance: none;
}
textarea, input {
  color: #4e5e72;
  background-color: transparent;
  background-image: url("data:image/svg+xml;utf8,<svg xmlns='http://www.w3.org/2000/svg' width='10' height='24'><rect fill='rgb(229, 225, 187)' x='0' y='23' width='10' height='1'/></svg>");
}
textarea {
 width: 100%;
 height: 8rem;
 resize: none;
}
input {
 width: 50%;
 margin-bottom: 1rem;
  &[type=text]:invalid, [type=email]:invalid {
    box-shadow: none;
    background-image: url("data:image/svg+xml;utf8,<svg xmlns='http://www.w3.org/2000/svg' width='10' height='24'><rect fill='rgba(240, 132, 114, 0.5)' x='0' y='23' width='10' height='1'/></svg>");
  }
}
button {
 padding: 0.5rem 1rem;
 border-radius: 0.25rem;
 background-color: rgba(78, 94, 114, 0.9);
 color: white;
 font-size: 1rem;
 transition: background-color 0.2s;
  &:hover,:focus {
    outline: none;
    background-color: rgba(78, 94, 114, 1);
  }
}
input[type=text]:focus,
input[type=email]:focus,
textarea:focus {
  background-image: url("data:image/svg+xml;utf8,<svg xmlns='http://www.w3.org/2000/svg' width='10' height='24'><rect fill='rgba(78, 94, 114, 0.3)' x='0' y='23' width='10' height='1'/></svg>");
  outline: none;
}
.wrapper {
  width: 35rem;
  background-color: white;
}
.letter {
  position: absolute;
  left: 0;
  right: 0;
  top: 0;
  width: 30rem;
  margin: auto;
  perspective: 60rem;
}
.side {
  height: 12rem;
  background-color: #fcfcf8;
  outline: 1px solid transparent;
  &:nth-of-type(1) {
    padding: 2rem 2rem 0;
    border-radius: 1rem 1rem 0 0;
    box-shadow: inset 0 0.75rem 2rem rgba(229, 225, 187, 0.5);
  }
  &.side:nth-of-type(2) {
    padding: 2rem;
    border-radius: 0 0 1rem 1rem;
    box-shadow: 0 0.3rem 0.3rem rgba(0, 0, 0, 0.05), inset 0 -0.57rem 2rem rgba(229, 225, 187, 0.5);
    text-align: right;
  }
}
.envelope {
  position: absolute;
  left: 0;
  right: 0;
  top: 0;
  margin: auto;
}
.envelope.front {
  width: 10rem;
  height: 6rem;
  border-radius: 0 0 1rem 1rem;
  overflow: hidden;
  z-index: 9999;
  opacity: 0;
}
.envelope.front::before, .envelope.front::after {
  position: absolute;
  display: block;
  width: 12rem;
  height: 6rem;
  background-color: #e9dc9d;
  transform: rotate(30deg);
  transform-origin: 0 0;
  box-shadow: 0 0 1rem rgba(0, 0, 0, 0.1);
  content: '';
}
.envelope.front::after{
  right: 0;
  transform: rotate(-30deg);
  transform-origin: 100% 0;
}
.envelope.back {
  top: -4rem;
  width: 10rem;
  height: 10rem;
  overflow: hidden;
  z-index: -9998;
  opacity: 0;
  transform: translateY(-6rem);
  &::before {
    display: block;
    width: 10rem;
    height: 10rem;
    background-color: #e9dc9d;
    border-radius: 1rem;
    content: '';
    transform: scaleY(0.6) rotate(45deg)
  }
}
.result-message {
  opacity: 0;
  transition: all 0.3s 2s;
  transform: translateY(9rem);
  z-index: -9999;
}
.sent {
  & .letter {
    animation: scaleLetter 1s forwards ease-in /*,
               pushLetter 0.5s 1.33s forwards ease-out*/ ;
  }
  & .side:nth-of-type(1) {
    transform-origin: 0 100%;
    animation: closeLetter 0.66s forwards ease-in;
  }
  & .side:nth-of-type(1) h1, .side:nth-of-type(1) textarea {
    animation: fadeOutText 0.66s forwards linear;
  }
  & button {
    background-color: rgba(78, 94, 114, 0.2);
  }
  & .envelope {
    animation: fadeInEnvelope 0.5s 1.33s forwards ease-out;
  }
  & .result-message {
    opacity: 1;
    transform: translateY(12rem);
  }
  & small {
    opacity: 0;
  }
}
.centered {
  position: absolute;
  left: 0;
  right: 0;
  margin: 1rem auto;
}
@keyframes closeLetter {
   50% {transform: rotateX(-90deg);}
   100% {transform: rotateX(-180deg);}
}
@keyframes fadeOutText {
   49% {opacity: 1;}
   50% {opacity: 0;}
   100% {opacity: 0;}
}
@keyframes fadeInEnvelope {
  0% {opacity: 0; transform: translateY(8rem);}
  /*90% {opacity: 1; transform: translateY(4rem);}*/
  100% {opacity: 1; transform: translateY(4.5rem);}
}
@keyframes scaleLetter {
  66% {transform: translateY(-8rem) scale(0.5, 0.5);}
  75% {transform: translateY(-8rem) scale(0.5, 0.5);}
  90% {transform: translateY(-8rem) scale(0.3, 0.5);}
  97% {transform: translateY(-8rem) scale(0.33, 0.5);}
  100%{transform: translateY(-8rem) scale(0.3, 0.5);}
}

</style>
</head>
<body>
<h1>CONTACT PAGE</h1>
<hr>
<small>Enter message (optional) and click button "Send"</small>
<div class="wrapper centered">
<form action="/sendEmailWithInlineContent" method="post" enctype="multipart/form-data">
    <div>
        <label for="to">To:</label>
        <input type="email" id="to" name="to" required>
    </div>
    <div>
        <label for="subject">Subject:</label>
        <input type="text" id="subject" name="sub" required>
    </div>
    <div>
        <label for="message">Message:</label>
        <textarea id="message" name="text" rows="5" required></textarea>
    </div>
    <div>
        <label for="file">Inline Image:</label>
        <input type="file" id="file" name="file" required>
    </div>
    <div>
        <button type="submit">Send Email</button>
    </div>
</form>



</div>
<p class="result-message centered">Thank you for your message</p>
</body>
</html>