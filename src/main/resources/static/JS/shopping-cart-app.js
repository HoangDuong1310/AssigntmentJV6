const app = angular.module('shopping-cart-app', [])

app.controller("shopping-cart-ctrl", function ($scope, $http) {
    // Quan Ly Gio Hang
    $scope.cart = {
        items: [],
        // Thêm sản phẩm vào giỏ hàng
        add(id) {
            var item = this.items.find(item => item.id == id);
            if (item) {
                item.qty++;
                this.saveToLocalStorage();
            } else {
                $http.get(`/rest/products/${id}`).then(response => {
                    response.data.qty = 1;
                    this.items.push(response.data);
                    this.saveToLocalStorage();

                })
            }
        },
        remove(id) {
            var index = this.items.findIndex(item => item.id == id);
            this.items.splice(index, 1);
            this.saveToLocalStorage();
        },
        get amount() {
            return this.items.map(item => item.qty * item.price).reduce((total, qty) => total += qty, 0);
        },
        get count() {
            return this.items.map(item => item.qty).reduce((total, qty) => total += qty, 0);

        },
        //Luu gio hang vao local storage
        saveToLocalStorage() {
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem('cart', json);
        },

        //Doc gio hang tu local storage
        loadFromLocalStorage() {
            var json = localStorage.getItem('cart');
            if (json) {
                this.items = JSON.parse(json);
            }
        }


    }
    $scope.cart.loadFromLocalStorage();

    $scope.order ={
        createDate: new Date(),
        address:"",
        account: {username: $("#username").text()},
        get orderDetails(){
            return $scope.cart.items.map(item => {
                return{
                    product:{id: item.id},
                    price: item.price,
                    quantity: item.qty
                }
            });
        },
        purchase(){
            var order = angular.copy(this);
            //thực hiệnd đặt hàng
            $http.post("/rest/orders", order).then(resp => {
                alert("Đặt hàng thành công");
                // $scope.cart.clear();
                location.href = "/order/detail/" + resp.data.id;
            }).catch(err => {
                alert("Đăng hàng không thành công")
                console.log(err);
            })

        }

    }
});



