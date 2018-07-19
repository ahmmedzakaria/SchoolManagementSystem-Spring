var doSomething = (function () {
  "use strict";
   return {
      test: (function () {
        return 'test';
      }()),
      test2: (function () {
        return console.log('test 2');
      })
   };
}());

