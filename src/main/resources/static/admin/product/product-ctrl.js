app.controller("product-ctrl", function ($scope, $http) {
    $scope.items = [];
    $scope.cates = [];
    $scope.form = {};

    $scope.initialize = function () {
        //load products
        $http.get("/rest/products").then(resp => {
            $scope.items = resp.data;
            $scope.items.forEach(item => {
                item.createDate = new Date(item.createDate)
            })
        });

        //load categories
        $http.get("/rest/categories").then(resp => {
            $scope.cates = resp.data;
        });
    }
    //Khoi dau
    $scope.initialize();

    //Xoa form
    $scope.reset = function () {
        $scope.form = {
            createDate: new Date,
            image: 'No_Image_Available.jpg',
            available: true,
            category:{
                id: '1000',
            },
        };
    }
    $scope.reset();

    //hien thi len form
    $scope.edit = function (item) {
        $scope.form = angular.copy(item);
        $(".nav-tabs a:eq(0)").tab('show')
    }

    //them san pham moi
    $scope.create = function () {
        var a =  document.getElementById('name').value;
        var b = document.getElementById('price').value;
        var d = document.getElementById('category').value;
        var av1 = document.getElementById('av1').value;
        var av2 = document.getElementById('av2').value;

        if (a == "" || b == "" ||  d == "" || av1 == ""){
            Swal.fire('Không được để trống các trường thông tin')
            return;
        }
        if (av1 == null && av2 == null )
        {
            Swal.fire('Không được để trống các trường thông tin')
            return;
        }
        var item = angular.copy($scope.form);
        console.log(item);
        $http.post(`/rest/products`, item).then(resp => {
            resp.data.createDate = new Date(resp.data.createDate)
            $scope.items.push(resp.data);
            $scope.reset()
            alert("them thanh cong")
        }).catch(err => {
            alert("Them that bai")
            console.log("Err", err);
        });

    }

    //cap nhap san pham
    $scope.update = function () {
        var a =  document.getElementById('name').value;
        var b = document.getElementById('price').value;
        var d = document.getElementById('category').value;
        var av1 = document.getElementById('av1').value;
        var av2 = document.getElementById('av2').value;

        if (a == "" || b == "" || d == "" || av1 == ""){
            Swal.fire('Không được để trống các trường thông tin')
            return;
        }
        if (av1 == null && av2 == null )
        {
            Swal.fire('Không được để trống các trường thông tin')
            return;
        }
        var item = angular.copy($scope.form);
        $http.put(`/rest/products/${item.id}`, item).then(resp => {
            var index = $scope.items.findIndex(p => p.id === item.id);
            $scope.items[index] = item;
            Swal.fire({
                icon: 'success',
                title: 'Cập Nhập Thành Công',
                footer: '<a href="">Why do I have this issue?</a>'
            })
        }).catch(err => {
            alert("Cap nhap that bai")
            console.log("Err", err);
        });
    }

    //xoa sam pham
    $scope.delete = function (item) {

        var item = $scope.items.find(or => or.id === item.id);
        if(item.available===false){
            item.available=true;
        }else if(item.available===true)
        {
            item.available=false;
        }
        $http.put(`/rest/products/delete/${item.id}` , item).then(resp => {
            var index = $scope.items.findIndex(p => p.id == item.id);
            $scope.reset();
            if(item.available===true){
                Swal.fire('Phục hồi sản phẩm thành công!');
            }else{
                Swal.fire('Xoá hồi sản phẩm thành công!');
            }
        }).catch(err => {
            alert("loi")
            console.log("Err", err);
        });
    }


    //upload hinh
    $scope.imageChanged = function (files) {
        var data = new FormData();
        data.append("file", files[0]);
        $http.post('/rest/upload/images', data, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(resp => {
            $scope.form.image = resp.data.name;
        }).catch(err => {
            alert("Loi upload");
            console.log("Err", err);
        })
    }
    $scope.pager = {
        page: 0,
        size: 10,
        get items() {
            var start = this.page * this.size;
            return $scope.items.slice(start, start + this.size);
        },
        get count() {
            return Math.ceil(1.0 * $scope.items.length / this.size);
        },
        first() {
            this.page = 0;
        },
        prev() {
            this.page--;
            if (this.page < 0) {
                this.last();
            }
        }
        ,
        next() {
            this.page++;
            if (this.page >= this.count) {
                this.first();
            }
        }
        ,
        last() {
            this.page = this.count - 1;
        }
    }

})


