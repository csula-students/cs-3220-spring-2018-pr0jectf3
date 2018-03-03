import constants from '../constants';
import Generator from '../models/generator';

export default function (store) {
	return class GeneratorComponent extends window.HTMLElement {
		constructor () {
			super();
			this.store = store;

			switch(this.dataset.id){
				case 0:
					this.meta = {
						type: 'generator',
						name: 'McCursor',
						description: 'A cursor that Auto-Makes Nuggets.',
						rate: 5,
						quantity: 0,
						baseCost: 5,
						unlockValue: 5
					}
					break;
				case 1:
					this.meta = {
						type: 'generator',
						name: 'McCursor',
						description: 'A cursor that Auto-Makes Nuggets.',
						rate: 5,
						quantity: 0,
						baseCost: 5,
						unlockValue: 5
					}
					break;
				case 2:
					this.meta = {
						type: 'generator',
						name: 'McCursor',
						description: 'A cursor that Auto-Makes Nuggets.',
						rate: 5,
						quantity: 0,
						baseCost: 5,
						unlockValue: 5
					}
					break;
				case 3:
					this.meta = {
						type: 'generator',
						name: 'McCursor',
						description: 'A cursor that Auto-Makes Nuggets.',
						rate: 5,
						quantity: 0,
						baseCost: 5,
						unlockValue: 5
					}
					break;
				case 4:
					this.meta = {
						type: 'generator',
						name: 'McCursor',
						description: 'A cursor that Auto-Makes Nuggets.',
						rate: 5,
						quantity: 0,
						baseCost: 5,
						unlockValue: 5
					}
					break;
				case 5:
					this.meta = {
						type: 'generator',
						name: 'McCursor',
						description: 'A cursor that Auto-Makes Nuggets.',
						rate: 5,
						quantity: 0,
						baseCost: 5,
						unlockValue: 5
					}
					break;
				case 6:
					this.meta = {
						type: 'generator',
						name: 'McCursor',
						description: 'A cursor that Auto-Makes Nuggets.',
						rate: 5,
						quantity: 0,
						baseCost: 5,
						unlockValue: 5
					}
					break;
			}
			// TODO: render generator initial view
			
			// TODO: subscribe to store on change event
			
				
			// TODO: add click event

		}
	};
}
