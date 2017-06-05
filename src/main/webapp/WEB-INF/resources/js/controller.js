var cartApp = angular.module("cartApp", []);

cartApp.controller("cartController", function($scope, $http) {
	$scope.refreshCart = function(cartId) {
		$http.get('/BookWorm/rest/cart/' + $scope.cartId).success(function(data) {
					$scope.cart = data;
				});
	};
	$scope.clearCart = function(){
		$http.delete('/BookWorm/rest/cart/'+$scope.cartId).success($scope.refreshCart($scope.cartId));
	};
	
	$scope.initCartId = function(cartId){
		$scope.cartId = cartId;
		$scope.refreshCart(cartId);
	}
	
	$scope.addToCart = function(bookId){
		$http.put('/BookWorm/rest/cart/add/'+bookId).success(function(data){
			$scope.refreshCart($http.get('/BookWorm/rest/cart/cartId'));
			alert("Book successfully added to the cart");
		});
	};
	$scope.removeFromCart= function(bookId){
		$http.put('/BookWorm/rest/cart/remove/'+bookId).success(function(data){
		$scope.refreshCart($http.get('/BookWorm/rest/cart/cartId'));	
		});
	};
});