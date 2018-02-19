// PubSub is single object for publish data to multiple subscribers
class PubSub {
    constructor () {
        this.subscribers = [];
    }

    // subscribe allows a new subscriber to listen for changes by providing
    // callback function in the parameter
    subscribe (fn) {
        this.subscribers.push(fn);
    }

    // one can publish any data to subscribers
    publish (data) {
        this.subscribers.forEach(subscriber => {
            subscriber(data);
        });
    }
}
//------------------------------------------------------------------------------
const pubSub = new PubSub();
var nugget = 0;
const button = document.querySelector('#clicker');

pubSub.subscribe(data => {
    console.log(nugget);
});

pubSub.publish(nugget);

//button.addEventListener('click', () =>{
//	pubSub.publish(window.state.nugget);
//	nugget = nugget + 1;
//	document.getElementById("nugget").innerHTML = nugget;
//	window.alert("hello");
//});
button.addEventListener('click', function(){
	nugget = nugget + 1;
	document.getElementById("nugget").innerHTML = nugget;
	pubSub.publish(window.state.nugget);
});



