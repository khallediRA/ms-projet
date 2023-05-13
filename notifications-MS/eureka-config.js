const Eureka = require('eureka-js-client').Eureka;

const eurekaClient = new Eureka({
  instance: {
    app: 'notification-service',
    hostName: 'localhost',
    ipAddr: '127.0.0.1',
    statusPageUrl: 'http://localhost:3000',
    port: {
      '$': 3000,
      '@enabled': 'true',
    },
    vipAddress: 'notification-service',
    dataCenterInfo: {
      '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
      name: 'MyOwn',
    },
  },
eureka: {
    host: 'localhost',
    port: 8070,
    servicePath: '/eureka/apps/',
  },
});

module.exports = eurekaClient;