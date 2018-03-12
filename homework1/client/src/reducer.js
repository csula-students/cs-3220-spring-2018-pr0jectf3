import Generator from '../src/models/generator';
export default function reducer (state, action) {
	switch (action.type) {



	case 'BUY_GENERATOR':
		var num = -1;
		for(var i = 0; i <= state.generators.length -1; i++){
			if(state.generators[i].name == action.payload.name){
				num = i;
			}
		}
		const generator = new Generator(Object.assign({}, state.generators[num]));
		var cost = Math.floor(generator.getCost());

		if(state.counter >= cost){
			state.counter = state.counter-cost;
			state.generators[num].quantity++;
		}

		return state;
	case 'BUTTON-CLICK':
		state.counter++;
		return state;
	case 'EXAMPLE_MUTATION':
		state.example = action.payload;
		return state;

	case 'INCREMENT':
		state.counter = state.counter + action.payload;
		return state;
		
	case 'CHECK_STORY':
		let stories = new Story(Object.assign({},state.story));
		for(var i = 0; i <= state.story.length -1; i++){
			if(story.isUnlockYet(state.counter)){
				state.story[i].state = 'visible';
			}
		}
		
		return state;
			
			
	default:
		return state;
	}
}


