<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp" %>   

             <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Tables</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading"> Board List Page
                        <button id='regBtn' type="button" class = "btn btn-xs pull-right" style = "background-color : lightgreen;" >Register New Board</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>#��ȣ</th>
                                        <th>����</th>
                                        <th>�ۼ���</th>
                                        <th>�ۼ���</th>
                                        <th>������</th>
                                    </tr>
                                </thead>
                                
                            <!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                                        </div>
                                        <div class="modal-body">ó���� �Ϸ�Ǿ����ϴ�.</div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-primary" data-dismiss="modal">Save changes</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- /.modal -->
                            
                                <c:forEach items="${list }" var="board">
                                <tr>
	                                <td><c:out value="${board.bno}"/></td>
	                                <td><a href='/board/get?bno=<c:out value = "${board.bno}"/>'>
	                                <c:out value="${board.title}"/></a></td>
	                                <td><c:out value="${board.writer}"/></td>
	                                <td><fmt:formatDate pattern="yyyy-MM-dd"
	                                	value="${board.regdate }" /></td>
	                                <td><fmt:formatDate pattern="yyyy-MM-dd"
	                                	value="${board.updateDate }" /></td>
	                            </tr>
	                            </c:forEach>
	                                                             
                            </table>
                            <!-- /.table-responsive -->
                            
                            <div class = 'row'>
                            	<div class="col-lg-12">
                            	
                            	<form id='searchForm' action="/board/list" method='get'>
                            		<select name='type'>
                            			<option value = ""
                            				<c:out value="${pageMaker.cri.type == null?'selected':''}"/>>--</option>
                            				
                            			<option value = "T"
                            				<c:out value="${pageMaker.cri.type eq 'T'?'selected':''}"/>>����</option>
                            				
                            			<option value = "C"
                            				<c:out value="${pageMaker.cri.type eq 'C'?'selected':''}"/>>����</option>
                            				
                            			<option value = "W"
                            				<c:out value="${pageMaker.cri.type eq 'W'?'selected':''}"/>>�ۼ���</option>
                            				
                            			<option value = "TC"
                            				<c:out value="${pageMaker.cri.type eq 'TC'?'selected':''}"/>>���� or ����</option>
                            				
                            			<option value = "TC"
                            				<c:out value="${pageMaker.cri.type eq 'TW'?'selected':''}"/>>���� or �ۼ���</option>
                            				
                            			<option value = "TC"
                            				<c:out value="${pageMaker.cri.type eq 'TWC'?'selected':''}"/>>���� or �ۼ��� or ���� </option>
                            				
                            		</select>
                            		<input type="text" name="keyword"
                            		value='<c:out value="${pageMaker.cri.keyword }"/>' />
                            		
                            		<input type="hidden" name="pageNum"
                            		value='<c:out value="${pageMaker.cri.pageNum }"/>' />
                            		
                            		<input type="hidden" name="amount"
                            		value='<c:out value="${pageMaker.cri.amount }"/>' />
                             		<button class='btn btn-default'>Search</button>
                            	</form>
                             	</div>
                            </div>
                            
                            
                            <form id='actionForm' action="/board/list" method='get'>
                            	<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum }'>
                            	<input type='hidden' name='amount' value='${pageMaker.cri.amount }'>                           	
                            	<input type='hidden' name='type' value='<c:out value="${pgeMaker.cri.type }"/>'>
                            	<input type='hidden' name='keyword' value='<c:out value="${pgeMaker.cri.keyword }"/>'>
                            </form>
                            
                             
                            
                            
                            <div class ='pull-right'>
                            	<ul class = "pagination">
                            		
                            		<c:if test="${pageMaker.prev }">
                            			<li class = "paginate_button previous"><a href="#">Previous</a>
                            			</li>
                            		</c:if>
                            		
                            		<c:forEach var="num" begin="${pageMaker.startPage }"
                            		end="${pageMaker.endPage }">
                            		<li class="paginate_button"><a href="#">${num }</a></li>
                            		</c:forEach>
                            		
                            		<c:if test="${pageMaker.next }">
                            			<li class="paginate_button next"><a href="#">Next</a></li>
                            		</c:if>
                            	</ul>
                            </div>
                            <!-- end Pagination -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->

<script type="text/javascript">
$(document).ready(function() {
	var result = '<c:out value="${result}"/>';
	
 	checkModal(result);
 	
 	history.replaceState({},null,null);
	
	function checkModal(result) {
		if (result === '' || history.state) {
			return;
		}
		if (parseInt(result) > 0) {
			$(".modal-body").html("�Խñ�" + parseInt(result) + "���� ��ϵǾ����ϴ�.");
		}
		
		$("#myModal").modal("show"); 
	}
	
	$("#regBtn").on("click",function(){
		self.location = "/board/register";
	});
});

var searchForm = $("#searchForm");

$("#searchForm button").on("click", function(e){
	
	if(!searchForm.find("option:selected").val()){
		alert("�˻������� �����ؤ�");
		return false;
	}
	
	if(!searchForm.find("input[name='keyword']").val()){
		alert("Ű���带 �Է��ؤ�");
		return false;	
	}
	
	searchForm.find("input[name='pageNum']").val("1");
	e.preventDefault();
	
	searchForm.submit();

});










</script>
          
<%@include file="../includes/footer.jsp" %>   
        

</html>
