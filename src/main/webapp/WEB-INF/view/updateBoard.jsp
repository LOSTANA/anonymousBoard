<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<div class="container p-5">
    <div class="card">
        <div class="card-header"><b>익명 글수정 화면입니다</b></div>
        <div class="card-body">
            <form action="/updateBoard/${boarder.id}" method="post">
                <div class="mb-3">
                    <textarea class="form-control" placeholder="제목을 수정하세요" name="title">${boarder.title}</textarea>
                </div>
                <div class="mb-3">
                    <textarea class="form-control" rows="5" name="contents">${boarder.contents}</textarea>
                </div>
                
                <button type="submit" class="btn btn-primary form-control">글수정완료</button>
            </form>
        </div>
    </div>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
