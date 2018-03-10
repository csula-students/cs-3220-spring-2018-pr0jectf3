import constants from '../constants';
import Generator from '../models/generator';

export default function (store) {
	return class GeneratorComponent extends window.HTMLElement {
		constructor () {
			super();
			this.onStateChange = this.handleStateChange.bind(this);
			this.store = store;

			
		}
		handleStateChange(newState){
			const generator = new Generator(Object.assign({}, newState.generators[this.dataset.id]));
			this.innerHTML = `<p class = 'jj'>
								<div class = 'button-buy'>
								<button class = 'gen'>
								<div class = 'top-row'>
								<h1 class = 'generator-name'>${generator.name}</h1>
								<h2 class = 'amt'>${generator.quantity}</h2>
								</div>
								<div class = 'cost'>price: ${Math.floor(generator.getCost())}</div>
								<span class="tooltiptext">
								<div class = 'description'>${generator.description}</div>
								<div class = 'rate'>rate: ${generator.rate} per min</div>
								</span>
								</div>
								</p><br/>`;
			
		}
		
		connectedCallback() {

			const generator = new Generator(Object.assign({}, store.state.generators[this.dataset.id]));



			this.innerHTML =  `<p>
								<div class = 'button-buy'>
								<button class = 'gen'>
								<div class = 'top-row'>
								<h1 class = 'generator-name'>${generator.name}</h1>
								<h2 class = 'amt'>${generator.quantity}</h2>
								</div>
								<div class = 'cost'>price: ${Math.floor(generator.getCost())}</div>
								<span class="tooltiptext">
								<div class = 'description'>${generator.description}</div>
								<div class = 'rate'>rate: ${generator.rate} per min</div>
								</span>
								</div>
								</p><br/>`;

			this.addEventListener('click', () => {
				this.store.dispatch({
					type: 'BUY_GENERATOR',
					payload: {
						name: generator.name
					}
				});
			});							 this.store.subscribe(this.onStateChange);
		}
		disconnectedCallback () {
			this.store.unsubscribe(this.onStateChange);
		}


	};

}