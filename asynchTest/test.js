function resolveAfter2Seconds(x) { 
    return new Promise(resolve => {
      setTimeout(() => {
        resolve(x);
      }, 2000);
    });
  }
  
  async function f1() {
    var x = await resolveAfter2Seconds([2,3,4,5,6,7,8,9,10]);
    x.forEach(element => {
        console.log(element);
    });
  }
  
  console.log("Hello1");

  f1();
  
  console.log("Hello2");