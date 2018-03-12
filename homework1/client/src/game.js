import Generator from './models/generator';

// default interval as 1 second

const interval = 1000;

/**
 * loop is main loop of the game, which will be executed once every second (
 * based on the interval variable configuration)
 */
export function loop (store) {
	// TODO: increment counter based on the generators in the state
	var counter = 0;

	// hint: read how many "generators" in store and iterate through them to
	//       count how many value to increment to "resource"
		
	for(let i = 0; i <= store.state.generators.length - 1; i++){
		let generator = new Generator(Object.assign({}, store.state.generators[i]));
		counter = counter + generator.generate();
	}
	// hint: remember to change event through `store.dispatch`
	store.dispatch({
		type: 'INCREMENT',
		payload: counter
	});
	

		// TODO: triggers stories from story to display state if they are passed
	
	//       the `triggeredAt` points
	// hint: use store.dispatch to send event for changing events state
	
	store.dispatch({
		type: 'CHECK_STORY'
	});

	// recursively calls loop method every second
	setTimeout(loop.bind(this, store), interval);
}
