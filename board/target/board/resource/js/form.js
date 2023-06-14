//정규식
//아이디, 비밀번호 영문 대소문자, 숫자, 최소 4자 이상 최대 8자 이하
const uidPw = /^[a-zA-Z0-9]{4,8}$/;

//이름
const uname = /^[가-힣a-zA-z]{2,15}$/;

//이메일
const uemail = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;

//전화번호
const utel = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;

window.onload = function(){
    if(getCookie("user")){
        document.getElementById("userid").value = getCookie("user");
        document.loginform.huid.checked = true;
    }
}

function Postcode() {
    new daum.Postcode({
        oncomplete: function (data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            let addr = ''; // 주소 변수
            let extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if (data.userSelectedType === 'R') {
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if (data.buildingName !== '' && data.apartment === 'Y') {
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if (extraAddr !== '') {
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("addr").value = extraAddr;

            } else {
                document.getElementById("addr").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode').value = data.zonecode;
            document.getElementById("addr").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("detailaddr").focus();
        }
    }).open();
}

function register(){
    //변수 정의
    const userid = document.getElementById("userid");
    const userpass = document.getElementById("userpass");
    const reuserpass = document.getElementById("reuserpass");
    const username = document.getElementById("username");
    const useremail = document.getElementById("useremail");
    const postcode = document.getElementById("postcode");
    const addr = document.getElementById("addr");
    const detailaddr = document.getElementById("detailaddr");
    const tel1 = document.getElementById("tel1");
    const tel2 = document.getElementById("tel2");
    const tel3 = document.getElementById("tel3");
    const tel = tel1.value + "-" + tel2.value + "-" + tel3.value;
    const useridok = document.getElementById("useridok");

    if(userid.vlaue == ""){
        alert("아이디를 입력하세요.");
        userid.focus();
        return false;
    }else if(!uidPw.test(userid.value)){
        alert("아이디는 영문, 숫자 4자 이상 8자 이하 입니다.");
        userid.value = "";
        userid.focus();
        return false;
    }/*
    else if(useridok.value == ""){
        alert("아이디 중복을 확인하세요.");
        userid.focus();
        return false;
    }*/
    else if(userpass.value == ""){
        alert("비밀번호를 입력하세요.");
        userpass.focus();
        return false()
    }else if(!uidPw.test(userpass.value)){
        alert("비밀번호는 영문, 숫자 4자 이상 8자 이하 입니다.");
        userpass.value = "";
        userpass.focus();
        return false;
    }else if(reuserpass.value != userpass.value){
        alert("비밀번호가 다릅니다.");
        reuserpass.value == "";
        reuserpass.focus();
        return false;
    }else if(username.value == ""){
        alert("이름을 입력하세요.");
        username.focus();
        return false;
    }else if(!uname.test(username.value)){
        alert("이름은 한글 또는 영문으로 2자 이상 적어 주세요.");
        username.value = "";
        username.focus();
        return false;
    }else if(useremail.value == ""){
        alert("이메일을 입력하세요.");
        useremail.focus();
        return false;
    }else if(!uemail.test(useremail.value)){
        alert("이메일 형식이 아닙니다. 다시 입력하세요.");
        useremail.focus();
        return false;
    }else if(postcode.value == ""){
        alert("주소를 입력하세요.");
        postcode.focus();
        return false;
    }else if(detailaddr.value == ""){
        alert("상세주소를 입력하세요.");
        detailaddr.focus();
        return false;
    }else if(tel1.value == ""){
        alert("전화번호를 입력하세요.");
        tel1.focus();
        return false;
    }else if(tel2.value == ""){
        alert("전화번호를 입력하세요.");
        tel2.focus();
        return false;
    }else if(tel3.value == ""){
        alert("전화번호를 입력하세요.");
        tel3.focus();
        return false;
    }else if(!utel.test(tel)){
        alert("전화번호 형식이 아닙니다. 다시 입력하세요.");
        tel1.focus();
        return false;
    }


    document.getElementById("tel").value = tel;
    //이상 없을 경우 submit
    document.registerform.submit();
}

function register2(){
    //변수 정의
    const userid = document.getElementById("userid");
    const userpass = document.getElementById("userpass");
    const reuserpass = document.getElementById("reuserpass");
    const username = document.getElementById("username");
    const useremail = document.getElementById("useremail");
    const postcode = document.getElementById("postcode");
    const addr = document.getElementById("addr");
    const detailaddr = document.getElementById("detailaddr");
    const tel1 = document.getElementById("tel1");
    const tel2 = document.getElementById("tel2");
    const tel3 = document.getElementById("tel3");
    const tel = tel1.value + "-" + tel2.value + "-" + tel3.value;
    const useridok = document.getElementById("useridok");

   
    if(userpass.value != "" && !uidPw.test(userpass.value)){
        alert("비밀번호는 영문, 숫자 4자 이상 8자 이하 입니다.");
        userpass.value = "";
        userpass.focus();
        return false;
    }else if(reuserpass.value != userpass.value){
        alert("비밀번호가 다릅니다.");
        reuserpass.value == "";
        reuserpass.focus();
        return false;
    }else if(username.value == ""){
        alert("이름을 입력하세요.");
        username.focus();
        return false;
    }else if(!uname.test(username.value)){
        alert("이름은 한글 또는 영문으로 2자 이상 적어 주세요.");
        username.value = "";
        username.focus();
        return false;
    }else if(useremail.value == ""){
        alert("이메일을 입력하세요.");
        useremail.focus();
        return false;
    }else if(!uemail.test(useremail.value)){
        alert("이메일 형식이 아닙니다. 다시 입력하세요.");
        useremail.focus();
        return false;
    }else if(postcode.value == ""){
        alert("주소를 입력하세요.");
        postcode.focus();
        return false;
    }else if(detailaddr.value == ""){
        alert("상세주소를 입력하세요.");
        detailaddr.focus();
        return false;
    }else if(tel1.value == ""){
        alert("전화번호를 입력하세요.");
        tel1.focus();
        return false;
    }else if(tel2.value == ""){
        alert("전화번호를 입력하세요.");
        tel2.focus();
        return false;
    }else if(tel3.value == ""){
        alert("전화번호를 입력하세요.");
        tel3.focus();
        return false;
    }else if(!utel.test(tel)){
        alert("전화번호 형식이 아닙니다. 다시 입력하세요.");
        tel1.focus();
        return false;
    }


    document.getElementById("tel").value = tel;
    //이상 없을 경우 submit
    document.edtregisterform.submit();
}


function loginSubmit(){
    const form = document.loginform;
    const is_checked = form.huid.checked;

    if(form.userid.value == ""){
        alert("아이디를 입력하세요.");
        form.userid.focus();
        return false;
    }else if(form.userpass.value == ""){
        alert("비밀번호를 입력하세요.");
        form.userpass.focus();
        return false;
    }
    if(is_checked){ // 체크박스에 체크 되어 있으면 쿠키를 생성한다.
        setCookie("user", form.userid.value, "3");
    }else{
        //체크가 되어있지 않다면 쿠키를 삭제한다.
        delCookie("user");
    }

    form.submit();
}

function isChecked(){
    const chk = document.loginform.huid;
    const is_checked = chk.checked;
    if(is_checked){
        let y = confirm("아이디를 저장하시겠습니까? \n 공공장소에서는 추천하지 않습니다.")
        if(y == false){
            chk.checked = false;
        }
    }
}

