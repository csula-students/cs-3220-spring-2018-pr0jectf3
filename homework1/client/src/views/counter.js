export default function (store) {
	return class CounterComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;
			// TODO: render counter inner HTML based on the store state

			this.onStateChange = this.handleStateChange.bind(this);
			this.textContent = this.store.state.counter;
		}

		handleStateChange (newState) {
			console.log('CounterComponent#stateChange', this, newState);
			// TODO: update inner HTML based on the new state
			this.innerHTML = `<h2 class ="count" id="nugget">${newState.counter}</h2>`;
		}

		connectedCallback () {
			this.innerHTML = '<h2 class ="count" id="nugget">0</h2>';
			this.store.subscribe(this.onStateChange);
		}

		disconnectedCallback () {
			this.store.unsubscribe(this.onStateChange);
		}
	};
}
 