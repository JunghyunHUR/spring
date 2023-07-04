<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="css/summernote-lite.min.css" />

<style>
    form{
        max-width: 1000px;
        background-color: #ededed;
        border: 1px solid #999;
        border-radius: 10px;
        padding: 30px;
        margin: auto;
    }
</style>

</head>
<body>
    <div class="container">
        <h1 class="text-center my-5">POST</h1>
        <form action="insertok" method="post">
            <div class="row">
                <div class="mb-3 mt-3">
                    <label for="writer" class="form-label">작성자 : </label>
                    <input type="text" class="form-control" placeholder="이름입력" name="writer" />
                </div>
                <div class="mb-3 mt-3 col-6">
                    <label for="categorya" class="form-label">브랜드 :</label>
                    <select name="categorya" class="form-control">
                        <option value="Fender">Fender</option>
                        <option value="Gipson">Gipson</option>
                        <option value="Epiphone">Epiphone</option>
                        <option value="Moolon">Moolon</option>
                        <option value="Martin">Martin</option>
                    </select>
                </div>
                <div class="mb-3 mt-3 col-6">
                    <label for="categoryb" class="form-label">바디 :</label>
                    <input type="text" class="form-control" placeholder="바디" name="categoryb" required />
                </div>
                <div class="mb-3 mt-3">
                    <label for="title" class="form-label">제목 : </label>
                    <input type="text" class="form-control" placeholder="제목입력" name="title" />
                </div>
                <div class="mb-3 mt-3">
                    <label for="content" class="form-label">내용 : </label>
                    <textarea class="form-control" name="content" id="content" ></textarea>
                </div>
            </div>
            <div class="text-center mt-5 mb-2">
                <button type="submit" class="btn btn-primary"> 등 록 </button>
            </div>
        </form>    
    </div>

    <script src="https://code.jquery.com/jquery-latest.min.js"></script>
    <script src="js/summernote-lite.min.js"></script>
    <script src="js/lang/summernote-ko-KR.min.js"></script>
    <script>
        $(function(){
            $('#content').summernote({
                lang: 'ko-KR',
                placeholer: "내용을 입력하세요.",
                tabsize: 2,
                height: 250,
                toolbar: [
                	  ['style', ['style']],
                	  ['font', ['bold', 'underline', 'clear']],
                	  ['fontname', ['fontname']],
                	  ['color', ['color']],
                	  ['para', ['ul', 'ol', 'paragraph']],
                	  ['table', ['table']],
                	  ['insert', ['link', 'picture']],
                	  ['view', ['fullscreen', 'codeview', 'help']],
                	],
                callbacks: {
                    //이미지 첨부를 위해 콜백

                    //이미지 업로드 함수 구현
                    onImageUpload: function(files){
                        uploadImageFile(files[0], "#content");
                    },
                    onPaste : function(e) { //업로드 된 이미지를 본문에 붙어넣기
                        let clipboardData = e.originalEvent.clipboardData;
                        if(clipboardData && clipboardData.items && clipboardData.items.length){
                            let item = clipboardData.items[0];
                            if(item.kind == 'file' && item.indexOf("images/") != -1){
                                e.preventDefault();
                            }
                        }
                    }
                }
            });
            //이미지 업로드 구현
            function uploadImageFile(file, editor){
                data = new FormData();
                data.append("file", file);
                $.ajax({
                    data: data,
                    type: "POST",
                    url: "./uploadImageFile",
                    contentType: false,
                    processData: false,
                    success: function(rs){
                        //업로드 한 파일의 url을 받아서 본문에 붙여야 함.
                        let res = JSON.parse(rs);
                        $(editor).summernote("insertImage", res.url);
                    }
                })
            }
        });//jquery
    </script>
</body>
</html>