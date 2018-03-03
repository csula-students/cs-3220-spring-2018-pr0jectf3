export default function reducer (state, action) {
	switch (action.type) {
	case 'BUY_GENERATOR':
		state.example = action.payload;
		return state;
	default:
		return state;
	}
}

