<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="/common/tablig.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="services-breadcrumb_w3ls_agileinfo">
		<div class="inner_breadcrumb_agileits_w3">

			<ul class="short">
				<li><a href="index.html">Home</a><i>|</i></li>
				<li>Check Out</li>
			</ul>
		</div>
	</div>
	<!-- //banner_inner -->
	</div>
	<c:if test="${not empty giohangs }">
		<div class="ads-grid_shop" id="contend">
			<div class="shop_inner_inf">
				<div class="privacy about">
					<h3>
						<span>Checkout</span>
					</h3>

					<div class="checkout-right">
						<h4>
							Your shopping cart contains: <span id="listSize">${listSize}</span>
							Products
						</h4>
						<table class="timetable_sub">
							<thead>
								<tr>
									<th>Product</th>
									<th>Quality</th>
									<th>Product Name</th>
									<th>Price</th>
									<th>Remove</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="item" items="${giohangs}">
									<tr>
										<input type="hidden" id="id" class="id" value="${item.id }" />
										<td class="invert-image" data-value="${item.image}"><a
											href='<c:url value="/single?code=${item.id}"/>'><img
												src="${item.image }" alt=" " class="img-responsive"></a></td>
										<td class="invert-quantity"><input class="SLgiohang"
											type="number" min="1" value="${item.count}" /></td>
										<td class="invert-name" data-value="${item.name}">${item.name}</td>
										<td class="invert-price" data-value="${item.price}">${item.price
										}</td>
										<td>
											<%-- <button>
												<a href='<c:url value="/checkout?codeId=${item.id }"/>'><i
													class="fa fa-trash" aria-hidden="true"></i></a>
											</button> --%>
											<button class="submitDeleteGioHang">
												<i class="fa fa-trash" aria-hidden="true"></i>
											</button>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="checkout-left">
						<div class="col-md-4 checkout-left-basket">
							<h4>Continue to basket</h4>
							<ul>
								<%-- <c:forEach var="item" items="${giohangs}">
									<li class="li-baset-price">${item.name}<i>-</i> <span
										id="baset-price">${item.price*item.count}</span></li>
								</c:forEach> --%>
								<!-- <li>Total Service Charges <i>-</i> <span>$55.00</span></li> -->
								<li style="font-size: 25px; color: red;">Total <i>-</i> <span
									id="tongtien">0</span></li>
							</ul>
						</div>
						<div class="col-md-8 address_form">
							<h4>Add a new Details</h4>
							<form>
								<section class="creditly-wrapper wrapper">
									<div class="information-wrapper">
										<div class="first-row form-group">
											<div class="controls">
												<label class="control-label">Full name: </label> <input
													class="inputname billing-address-name form-control"
													type="text" name="name" placeholder="Full name">
											</div>
											<div class="card_number_grids">
												<div class="card_number_grid_left">
													<div class="controls">
														<label class="control-label">Mobile number:</label> <input
															class="inputphone form-control" type="number"
															placeholder="Mobile number">
													</div>
												</div>
												<div class="card_number_grid_right">
													<div class="controls">
														<label class="control-label">Address: </label> <input
															class="inputaddress form-control" type="text"
															placeholder="Address">
													</div>
												</div>
												<div class="card_number_grid_right">
													<div class="controls">
														<label class="control-label">Note: </label> <input
															class="inputnote form-control" type="text"
															placeholder="Note">
													</div>
												</div>
												<div class="clear"></div>
											</div>

										</div>
										<input style="font-size: 30px; color: red; background: black;"
											type="button" id="payment" value="Payment" />
									</div>
								</section>
							</form>

						</div>

						<div class="clearfix"></div>


						<div class="clearfix"></div>
					</div>
				</div>
			</div>
		</div>
	</c:if>
	<c:if test="${empty giohangs }">
		<div class="ads-grid_shop">
			<div class="shop_inner_inf">
				<div class="privacy about">
					<h3>
						<span>Checkout</span>
					</h3>

					<div class="checkout-right">
						<h4>
							Your shopping cart contains: <span>0 Products</span>
						</h4>
						<table class="timetable_sub">
							<thead>
								<tr>
									<th>Product</th>
									<th>Quality</th>
									<th>Product Name</th>
									<th>Price</th>
									<th>Remove</th>
								</tr>
							</thead>

						</table>
					</div>
					<div class="checkout-left">
						<div class="col-md-4 checkout-left-basket">
							<h4>Continue to basket</h4>
							<ul>
								<li>Product1 <i>-</i> <span>0</span></li>
								<li>Product2 <i>-</i> <span>0 </span></li>
								<li>Product3 <i>-</i> <span>0 </span></li>
								<li>Total Service Charges <i>-</i> <span>0</span></li>
								<li>Total <i>-</i> <span id="tongtien">0</span></li>
							</ul>
						</div>
						<div class="col-md-8 address_form">
							<h4>Add a new Details</h4>
							<form action="payment.html" method="post"
								class="creditly-card-form agileinfo_form">
								<section class="creditly-wrapper wrapper">
									<div class="information-wrapper">
										<div class="first-row form-group">
											<div class="controls">
												<label class="control-label">Full name: </label> <input
													class="inputname billing-address-name form-control"
													type="text" name="name" placeholder="Full name">
											</div>
											<div class="card_number_grids">
												<div class="card_number_grid_left">
													<div class="controls">
														<label class="control-label">Mobile number:</label> <input
															class="inputphone form-control" type="number"
															placeholder="Mobile number">
													</div>
												</div>
												<div class="card_number_grid_right">
													<div class="controls">
														<label class="control-label">Address: </label> <input
															class="inputaddress form-control" type="text"
															placeholder="Address">
													</div>
												</div>
												<div class="card_number_grid_right">
													<div class="controls">
														<label class="control-label">Note: </label> <input
															class="inputnote form-control" type="text"
															placeholder="Note">
													</div>
												</div>
												<div class="clear"></div>
											</div>
										</div>
										<button id="payment" class="submit check_out">Delivery
											to this Address</button>
									</div>
								</section>
							</form>

						</div>

						<div class="clearfix"></div>


						<div class="clearfix"></div>
					</div>
				</div>
			</div>
		</div>
	</c:if>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
		
	</script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(
				function() {
					GanTongTien();
					function GanTongTien(isIventChange) {
						var tongtien = 0;
						$(".invert-price").each(
								function() {
									var giatienTT = $(this).attr("data-value");
									var soluong = $(this).closest("tr").find(
											".SLgiohang").val();
									var giatien = parseFloat(giatienTT)
											* parseFloat(soluong);
									var formatGiatien = parseFloat(giatien)
											.toFixed(3).replace(
													/(\d)(?=(\d{3})+\.)/g,
													"$1.").toString()
									tongtien = parseFloat(tongtien)
											+ parseFloat(giatien);
									if (!isIventChange) {
										$(this).html(formatGiatien);
									}

									var formatTongtien = parseFloat(tongtien)
											.toFixed(3).replace(
													/(\d)(?=(\d{3})+\.)/g,
													"$1.").toString();
									$("#tongtien").html(formatTongtien);

								})
					}
					;
					$('.SLgiohang').change(
							function() {
								var count = $(this).val();
								var price = $(this).closest("tr").find(
										".invert-price").attr("data-value");
								var tongtien = count * price;
								var format = parseFloat(tongtien).toFixed(3)
										.replace(/(\d)(?=(\d{3})+\.)/g, "$1.")
										.toString();
								$(this).closest("tr").find(".invert-price")
										.html(format);
								GanTongTien(true);

								var id = $(this).closest("tr").find("#id")
										.val();
								var image = $(this).closest("tr").find(
										".invert-image").attr("data-value");
								var name = $(this).closest("tr").find(
										".invert-name").attr("data-value");

								$.ajax({
									url : '/do-an-giua-ki/api-checkout',
									type : 'PUT',
									contentType : 'application/json',
									dataType : 'json',
									data : JSON.stringify({
										id : id,
										name : name,
										image : image,
										price : price,
										count : count
									}),
									success : function(re) {
									}
								});
							});
					$("#payment").click(
							function() {
								var user = $(".inputname").val();
								var phone = $(".inputphone").val();
								var address = $(".inputaddress").val();
								var note = $(".inputnote").val();
								var tongtien = $("#tongtien").text();
								$.ajax({
									url : '/do-an-giua-ki/api-payment',
									type : 'POST',
									data : {
										user : user,
										phone : phone,
										address : address,
										note : note,
										tongtien : tongtien
									},
									success : function(re) {
										$("#listsize").html(0);
										var contend = document
												.getElementById("contend");
										contend.innerHTML = re;
									}
								});
							});
					$('.submitDeleteGioHang').click(function(e) {
						e.preventDefault();
						var self = $(this);
						var id = $(this).closest("tr").find(".id").val();
						$.ajax({
							url : 'http://localhost:8080/do-an-giua-ki/api-checkout'+'?'+$.param({"id":id}),
							type : 'DELETE',
							success : function(value) {
								self.closest("tr").remove();
								$("#listsize").html(value);
								$("#listSize").html(value);
								GanTongTien(true);
								if(value==0){
									$("#tongtien").html(value);
								}
							}
						});
					});
				});
	</script>
</body>
</html>