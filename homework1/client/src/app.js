import '@webcomponents/webcomponentsjs';

import {loop} from './game';
import Store from './store';
import reducer from './reducer';

import ButtonComponent from './views/button';
import CounterComponent from './views/counter';
import ExampleComponent from './views/example';
import GeneratorComponent from './views/generator';
import StoryBookComponent from './views/story-book';

/**
 * Data flow diagram
 +----------------------------------------------------+
 | +------------------+          +------------------+ |
 | |                  |          |                  | |
++-|       Loop       |<---------|    Generator     | |
|| |                  |          |                  | |
|| +------------------+          +------------------+ |
||G          ^                                        |
||a          +-----------------------------+          |
||m                                        |          |
||e                                        |          |
||                               +------------------+ |
||                               |                  | |
||                               |     Stories      | |
||                               |                  | |
||                               +------------------+ |
|+----------------------------------------------------+
+------------------------------------------------------------+
|                                                            |
|                                                            |
|                                                            |
|                                                            |
|                                                            |
|                                                            |
|                                                            |
|                                                            |
|       +----------------------------------------------------+----------+
|       | +------------------+                     +------------------+ |
|       | |                  |        Mutates      |                  | |
|       | |     Reducer      |-------------------->|      State       | |
|       | |                  |                     |                  | |
|       | +------------------+                     +------------------+ |
|       |S          ^                                        |          |
|       |t          |                                        |          |
|       |o          |                                        |          |
|       |r          | Triggers                     Notifies  |          |
|       |e          |                                        |          |
|       |           |                                        v          |
|       | +------------------+                     +------------------+ |
|       | |                  |                     |                  | |
+-------+>|      Action      |                     |    Listeners     | |
        | |                  |                     |                  | |
        | +------------------+                     +------------------+ |
        +-----------^----------------------------------------+----------+
                    |                                        |
                    |                                        |
                    |                                        |
                    |                                        |
                    | Dispatches                             |
                    |                                        |
                    |                                        |
          +------------------+                               |
          |                  |                               |
          |      Views       |              Notifies changes |
          |    Components    |<------------------------------+
          |                  |
          +------------------+
 */
main();

// main function wraps everything at top level
function main () {
	// TODO: fill the blank based on the theme you have choosen
	const initialState = {
		example: 'Hello custom element',
		counter: 0,
		generators: [
			{
				name: 'McCursor',
				description: 'automatically generates nuggets per second',
				rate: 1,
				baseCost: 10,
				quantity: 0,
				unlockValue:10
				
			},
			{
				name: 'McChicken',
				description: 'The chicken lays golden nuggets',
				rate: 25,
				baseCost: 20,
				quantity: 0,
				unlockValue:20
			},
			{
				name: 'McFarmer',
				description: 'Farmer breeds McChickens',
				rate: 100,
				baseCost: 125,
				quantity: 0,
				unlockValue:125
			},
			{
				name: 'McSlaughterHouse',
				description: 'kills McChickens to produce nuggets quickly',
				rate: 500,
				baseCost: 500,
				quantity: 0,
				unlockValue:500
			},
			{
				name: 'McBank',
				description: 'Safe place to store McNuggets',
				rate: 1000,
				baseCost: 1250,
				quantity: 0,
				unlockValue: 1250
			},
			{
				name: 'RonaldMcDonald',
				description: 'The king of all Chicken McNuggets',
				rate: 5000,
				baseCost: 3000,
				quantity: 0,
				unlockValue: 3000
			},
			{
				name: 'McDonalds',
				description: 'The McNugget Kingdom located by your nearby block',
				rate: 10000,
				baseCost: 15000,
				quantity: 0,
				unlockValue:15000
			}],
		story: [
			{
			name: 'Gotta protect them McNuggets!',
			description: 'Make them, Make them, Make them!!!',
			triggeredAt: 20,
			state: 'hidden'
		},
			{
			name: 'Hey you are really good at this!',
			description: 'I LOVE CHICKEN NUGGETSSSS!!!',
			triggeredAt: 40,
			state: 'hidden'
		},
			{
			name: 'Ronald is eating all the nuggets!',
			description: 'HURRY, WE ARE RUNNING OUT OF NUGGETS!!!',
			triggeredAt: 60,
			state: 'hidden'
		},
			{
			name: 'You are the Nugget GOD!',
			description: 'YUM YUM YUM YUM!!!',
			triggeredAt: 100,
			state: 'hidden'
		},
			   ]
	};

	// initialize store
	const store = new Store(reducer, initialState);
	//console.log(ExampleComponent(store));

	// define web components
	window.customElements.define('component-example', ExampleComponent(store)); 
	window.customElements.define('game-button', ButtonComponent(store));
	window.customElements.define('game-counter', CounterComponent(store));
	// lab 3
	window.customElements.define('game-generator', GeneratorComponent(store));
	// homework 1
	window.customElements.define('game-story-book', StoryBookComponent(store));

	// For ease of debugging purpose, we will expose the critical store under window
	// ps: window is global
	window.store = store;

	// start game loop
	loop(store);
}
