export default function (store) {
	return class ButtonComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;

			//this.onStateChange = this.handleStateChange.bind(this);

			// TODO: add click event to increment counter
			// hint: use "store.dispatch" method (see example component)
		}
		
		//use connected callback and disconnected call back
		
		connectedCallback(){
			this.innerHTML = '<button class="clicker" id="clicker"></button>';
			this.addEventListener('click', ()=> {
				this.store.dispatch({
					type: 'BUTTON-CLICK'
				});
			});
		}
		
		disconnectedCallback(){
			this.store.unsubscribe(this.onStateChange);
		}
	};
}
