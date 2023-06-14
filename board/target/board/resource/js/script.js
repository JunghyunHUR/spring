/*
$(document).ready(function(){
    // 저장된 쿠키값을 가져와서 ID 칸에 넣어준다. 없으면 공백으로 들어감.
    let key = getCookie("key");
    $("#userid").val(key);
    
    // 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
    if($("#userid").val() != ""){ 
        $("#huid").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
    }
    
    $("#huid").change(function(){ // 체크박스에 변화가 있다면,
        if($("#huid").is(":checked")){ // ID 저장하기 체크했을 때,
            setCookie("key", $("#userid").val(), 3); // 3일 동안 쿠키 보관
        }else{ // ID 저장하기 체크 해제 시,
            deleteCookie("key");
        }
    });
    
    // ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
    $("#userid").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
        if($("#huid").is(":checked")){ // ID 저장하기를 체크한 상태라면,
            setCookie("key", $("#userid").val(), 3); // 3일 동안 쿠키 보관
        }
    });

    // 쿠키 저장하기 
    // setCookie => saveid함수에서 넘겨준 시간이 현재시간과 비교해서 쿠키를 생성하고 지워주는 역할
    function setCookie(cookieName, value, exdays) {
    let exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    let cookieValue = escape(value)
            + ((exdays == null) ? "" : "; expires=" + exdate.toGMTString());
    document.cookie = cookieName + "=" + cookieValue;
    }

    // 쿠키 삭제
    function deleteCookie(cookieName) {
    let expireDate = new Date();
    expireDate.setDate(expireDate.getDate() - 1);
    document.cookie = cookieName + "= " + "; expires="
            + expireDate.toGMTString();
    }

    // 쿠키 가져오기
    function getCookie(cookieName) {
    cookieName = cookieName + '=';
    let cookieData = document.cookie;
    let start = cookieData.indexOf(cookieName);
    let cookieValue = '';
    if (start != -1) { // 쿠키가 존재하면
        start += cookieName.length;
        let end = cookieData.indexOf(';', start);
        if (end == -1) // 쿠키 값의 마지막 위치 인덱스 번호 설정 
            end = cookieData.length;
            console.log("end위치  : " + end);
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
    }
})//jquery */

function findIdPw(){
	const url = "/board/member/findIdPw.jsp";
	const width = 500, height = 350;
	let left = (document.body.offsetWidth / 2) - (width / 2);
	let top = (document.body.offsetHeight / 2) - (height / 2);
	left += window.screenLeft;
	
	window.open(url, "popup", `width=${width}, height=${height}, left=${left}, top=${top}`);
	
}
function memLevel(e, i, num){
    const val = e.value;
    const mems = ["탈퇴회원", "일반회원", "유료회원", "VIP회원"];

    let y = confirm("회원정보를" + mems[val] + "으로 수정하시겠습니까?")

    if(y){
        //회원정보 수정
        fetch("/board/LevelUpdate?level=" + val + "&num=" + num)
        .then(res => res.json())
        .then(data => {
            if(data > 0){
                alert("수정 완료");
            }else{
                alert("문제가 발생했습니다. 다시 시도하세요.");
                location.reload();
            }
        });
    }else{
        e.options[i].selected = true;
        return false;
    }
}

function findId(){
    const name = document.findIdform.username;
    const email = document.findIdform.useremail;
    
    if(name.value == ''){
        alert("이름을 입력하세요");
        name.focus();
        return false;
    }else if(email.value == ''){
        alert("이메일을 입력하세요");
        email.focus();
        return false;
    }
    document.findIdform.submit();
}
function findPwd(){
    const id = document.findPwdform.userid;
    const email = document.findPwdform.useremail;
    if(id.value == ""){
        alert("아이디를 입력하세요");
        id.focus();
        return false;
    }else if(email.value == ''){
        alert("이메일을 입력하세요");
        email.focus();
        return false;
    }
    document.findPwdform.submit();
}
function cancel(){
    window.close();
}

/****** board write *******/

function writeBoard(){
    const title = document.getElementById("title");
    const content = document.getElementById("content");
    if(title.value == null || title.value == ""){
        alert("제목을 입력하세요");
        title.focus();
        return false;
    }else if(content.value == '' || content.value == null){
        alert("내용을 입력하세요");
        content.focus();
        return false;
    }
    document.boardfrom.submit();
}
