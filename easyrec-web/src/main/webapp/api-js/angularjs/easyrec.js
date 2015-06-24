/**Copyright 2015 Research Studios Austria Forschungsgesellschaft mBH
 *
 * This file is part of easyrec.
 *
 * easyrec is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * easyrec is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with easyrec.  If not, see <http://www.gnu.org/licenses/>.
 */
var easyrecServices = angular.module('easyrecServices', []);

easyrecServices.service('delay', ['$q', '$timeout', 
        function ($q, $timeout) {
            return {
              /**
               * ggfgfgf
               * @param {type} $q
               * @param {type} $http
               * @returns {themoviedb.hmtl_L31.themoviedb.hmtlAnonym$5}
               */
              start: function () {
                  var deferred = $q.defer();
                  $timeout(deferred.resolve, 200);
                  return deferred.promise;
              }  
            };
        }]);

easyrecServices.provider('easyrec', function easyrecProvider() {
    var baseUrl = 'http://demo.easyrec.org';
    var apikey = '';
    var tenant = '';
    
    this.setBaseUrl = function(url) {
        baseUrl = url;
    };
    
    this.setApiKey = function(key) {
        apikey = key;
    };
    
    this.setTenant = function(t) {
        tenant = t;
    };
    
    this.$get = ['$q','$http', function easyrecFactory($q, $http) {
        return {
            view: function(sessionid, itemid, itemtype, itemdescription, itemurl, itemimageurl, userid, actioninfo) {
                var deferred = $q.defer();
                $http.get(baseUrl + '/api/1.1/json/view',
                {params : {
                        apikey: apikey,
                        tenantid: tenant,
                        sessionid : sessionid,
                        itemid : itemid,
                        itemtype : itemtype,
                        itemdescription : itemdescription,
                        itemurl : itemurl,
                        itemimageurl : itemimageurl,
                        userid: userid,
                        actioninfo : actioninfo
                    }
                }).success(function(data, status) {
                    if (!angular.isArray(data)) {
                        deferred.resolve(data.recommendedItems);
                    } else { //was error
                        deferred.reject(data[0].message);
                    }
                }).error(function(data, status) {
                    deferred.reject(status + data);
                });
                return deferred.promise;
            },
            buy: function(sessionid, itemid, itemtype, itemdescription, itemurl, itemimageurl, userid, actioninfo) {
                var deferred = $q.defer();
                $http.get(baseUrl + '/api/1.1/json/buy',
                {params : {
                        apikey: apikey,
                        tenantid: tenant,
                        sessionid : sessionid,
                        itemid : itemid,
                        itemtype : itemtype,
                        itemdescription : itemdescription,
                        itemurl : itemurl,
                        itemimageurl : itemimageurl,
                        userid: userid,
                        actioninfo : actioninfo
                    }
                }).success(function(data, status) {
                    if (!angular.isArray(data)) {
                        deferred.resolve(data.recommendedItems);
                    } else { //was error
                        deferred.reject(data[0].message);
                    }
                }).error(function(data, status) {
                    deferred.reject(status + data);
                });
                return deferred.promise;
            },
            rate: function(sessionid, itemid, itemtype, itemdescription, itemurl, itemimageurl, userid, actioninfo, ratingvalue) {
                var deferred = $q.defer();
                $http.get(baseUrl + '/api/1.1/json/rate',
                {params : {
                        apikey: apikey,
                        tenantid: tenant,
                        sessionid : sessionid,
                        itemid : itemid,
                        itemtype : itemtype,
                        itemdescription : itemdescription,
                        itemurl : itemurl,
                        itemimageurl : itemimageurl,
                        userid: userid,
                        actioninfo : actioninfo,
                        ratingvalue : ratingvalue
                    }
                }).success(function(data, status) {
                    if (!angular.isArray(data)) {
                        deferred.resolve(data.recommendedItems);
                    } else { //was error
                        deferred.reject(data[0].message);
                    }
                }).error(function(data, status) {
                    deferred.reject(status + data);
                });
                return deferred.promise;
            },
            sendaction: function(sessionid, itemid, itemtype, itemdescription, itemurl, itemimageurl, userid, actioninfo, actiontype, actionvalue) {
                var deferred = $q.defer();
                $http.get(baseUrl + '/api/1.1/json/sendaction',
                {params : {
                        apikey: apikey,
                        tenantid: tenant,
                        sessionid : sessionid,
                        itemid : itemid,
                        itemtype : itemtype,
                        itemdescription : itemdescription,
                        itemurl : itemurl,
                        itemimageurl : itemimageurl,
                        userid: userid,
                        actioninfo : actioninfo,
                        actiontype : actiontype,
                        actionvalue : actionvalue
                    }
                }).success(function(data, status) {
                    if (!angular.isArray(data)) {
                        deferred.resolve(data.recommendedItems);
                    } else { //was error
                        deferred.reject(data[0].message);
                    }
                }).error(function(data, status) {
                    deferred.reject(status + data);
                });
                return deferred.promise;
            },
            mostviewed: function(requesteditemtype, timerange) {
                var deferred = $q.defer();
                $http.get(baseUrl + '/api/1.1/json/mostvieweditems',
                {params : {
                        apikey: apikey,
                        tenantid: tenant,
                        timeRange: timerange,
                        requesteditemtype : requesteditemtype
                    }
                }).success(function(data, status) {
                    if (!angular.isArray(data)) {
                        deferred.resolve(data.recommendedItems);
                    } else { //was error
                        deferred.reject(data[0].message);
                    }
                }).error(function(data, status) {
                    deferred.reject(status + data);
                });
                return deferred.promise;
            }, 
            bestrated: function(requesteditemtype, timerange) {
                var deferred = $q.defer();
                $http.get(baseUrl + '/api/1.1/json/bestrateditems',
                {params : {
                        apikey: apikey,
                        tenantid: tenant,
                        timeRange: timerange,
                        requesteditemtype : requesteditemtype
                    }
                }).success(function(data, status) {
                    if (!angular.isArray(data)) {
                        deferred.resolve(data.recommendedItems);
                    } else { //was error
                        deferred.reject(data[0].message);
                    }
                }).error(function(data, status) {
                    deferred.reject(status + data);
                });
                return deferred.promise;
            },
            getprofile: function(itemid, itemtype) {
                var deferred = $q.defer();
                $http.get(baseUrl + '/api/1.1/json/profile/load',
                {params : {
                        apikey: apikey,
                        tenantid: tenant,
                        itemid: itemid,
                        itemtype : itemtype
                    }
                }).success(function(data, status) {
                    if (!angular.isArray(data)) {
                        deferred.resolve(data.value);
                    } else { //was error
                        deferred.reject(data[0].message);
                    }
                }).error(function(data, status) {
                    deferred.reject(status + data);
                });
                return deferred.promise;
            },
            getprofilefield: function(itemid, itemtype, path) {
                var deferred = $q.defer();
                $http.get(baseUrl + '/api/1.1/json/profile/field/load',
                {params : {
                        apikey: apikey,
                        tenantid: tenant,
                        itemid: itemid,
                        itemtype : itemtype,
                        path : path
                    }
                }).success(function(data, status) {
                    if (!angular.isArray(data)) {
                        deferred.resolve(data.value);
                    } else { //was error
                        deferred.reject(data[0].message);
                    }
                }).error(function(data, status) {
                    deferred.reject(status + data);
                });
                return deferred.promise;
            },
            alsoviewed: function(itemid, itemtype, requesteditemtype) {
                var deferred = $q.defer();
                $http.get(baseUrl + '/api/1.1/json/otherusersalsoviewed',
                {params : {
                        apikey: apikey,
                        tenantid: tenant,
                        itemid: itemid,
                        itemtype : itemtype,
                        requesteditemtype : requesteditemtype
                    }
                }).success(function(data, status) {
                    if (!angular.isArray(data)) {
                        deferred.resolve(data.recommendedItems);
                    } else { //was error
                        deferred.reject(data[0].message);
                    }
                }).error(function(data, status) {
                    deferred.reject(status + data);
                });
                return deferred.promise;
            },
            relateditems: function(itemid, itemtype, assoctype, requesteditemtype) {
                var deferred = $q.defer();
                $http.get(baseUrl + '/api/1.1/json/relateditems',
                {params : {
                        apikey: apikey,
                        tenantid: tenant,
                        itemid: itemid,
                        itemtype : itemtype,
                        assoctype : assoctype,
                        requesteditemtype : requesteditemtype
                    }
                }).success(function(data, status) {
                    if (!angular.isArray(data)) {
                        deferred.resolve(data.recommendedItems);
                    } else { //was error
                        deferred.reject(data[0].message);
                    }
                }).error(function(data, status) {
                    deferred.reject(status + data);
                });
                return deferred.promise;
            },
            storeprofile: function(itemid, itemtype,requesteditemtype) {
                var deferred = $q.defer();
                $http.get(baseUrl + '/api/1.1/json/profile/store',
                {params : {
                        apikey: apikey,
                        tenantid: tenant,
                        itemid: itemid,
                        itemtype : itemtype,
                        requesteditemtype : requesteditemtype
                    }
                }).success(function(data, status) {
                    if (!angular.isArray(data)) {
                        deferred.resolve(data.recommendedItems);
                    } else { //was error
                        deferred.reject(data[0].message);
                    }
                }).error(function(data, status) {
                    deferred.reject(status + data);
                });
                return deferred.promise;
            },
            storeitemwithprofile: function(itemid, itemtype, itemdescription, itemurl, itemimageurl, profile) {
                var deferred = $q.defer();
                $http.post(baseUrl + '/api/1.1/json/profile/storeitemwithprofile',
                {
                        apikey: apikey,
                        tenantid: tenant,
                        itemid: itemid,
                        itemtype : itemtype,
                        itemdescription : itemdescription,
                        itemurl : itemurl,
                        itemimageurl : itemimageurl,
                        profile : profile
                    }
                ).success(function(data, status) {
                    if (!angular.isArray(data)) {
                        deferred.resolve(data.recommendedItems);
                    } else { //was error
                        deferred.reject(data[0].message);
                    }
                }).error(function(data, status) {
                    deferred.reject(status + data);
                });
                return deferred.promise;
            },
            itemtypes: function() {
                var deferred = $q.defer();
                $http.get(baseUrl + '/api/1.1/json/itemtypes',
                {params : {
                        apikey: apikey,
                        tenantid: tenant
                    }
                }).success(function(data, status) {
                    if (!angular.isArray(data)) {
                        deferred.resolve(data.itemType);
                    } else { //was error
                        deferred.reject(data[0].message);
                    }
                }).error(function(data, status) {
                    deferred.reject(status + data);
                });
                return deferred.promise;
            },
            getdata: function(filename) {
                var deferred = $q.defer();
                $http.get('http://localhost:8084/AAA/' + filename,
                {params : {
 
                    }
                }).success(function(data, status) {
                    if (angular.isArray(data)) {
                        deferred.resolve(data);
                    } else { //was error
                        deferred.reject("Error loading products!");
                    }
                }).error(function(data, status) {
                    deferred.reject(status + data);
                });
                return deferred.promise;
            }          
        };
    }];
});