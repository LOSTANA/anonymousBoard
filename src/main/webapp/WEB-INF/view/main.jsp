<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/view/layout/header.jsp"%>

			<div class="container" style="margin-top: 30px">
				<c:choose>
					<c:when test="${boardList !=null}">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>내용</th>
									<th>작성자</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="list" items="${boardList}">
									<tr>
										<td>${list.id}</td>
										<td>${list.title}</td>
										<td>${list.contents}</td>
										<td>${list.username}</td>
										<td>
											<div class="d-flex">
												<form action="#">
													<button class="btn btn-danger">삭제</button>
												</form>
												<form action="/updateBoard/${list.id}" method="get">
													<button class="btn btn-warning">수정</button>
												</form>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</c:when>
					<c:otherwise>
						<div class="jumbotron display-4">
							<h5>아직 생성된 게시물이 없습니다.</h5>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	
	<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
