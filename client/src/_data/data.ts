type Profession = {
	profession: string;
};

type Direction = {
	number: string;
	direction: string;
	contestGroup: string;
	placeBudget: number;
	placeContract: number;
	price: number;
	subjectOne: string;
	subjectTwo: string;
	subjectThree: string;
	minPointOne: number;
	minPointTwo: number;
	minPointThree: number;
	pointPreviousYear: number;
	contestBudget: number;
	contestContract: number;
	profession: Profession[];
};

export const directions: Direction[] = [
	{
		number: '12.03.01',
		direction: '12.03.01 Приборостроение',
		contestGroup:
			'Приборостроение (Лазерные, акустические и навигационные системы)',
		placeBudget: 85,
		placeContract: 22,
		price: 135000,
		subjectOne: 'Математика',
		subjectTwo: 'Информатика',
		subjectThree: 'Русский язык',
		minPointOne: 50,
		minPointTwo: 50,
		minPointThree: 50,
		pointPreviousYear: 205,
		contestBudget: 13,
		contestContract: 6,
		profession: [
			{
				profession: 'Системный администратор',
			},
			{
				profession: 'DevOps',
			},
			{
				profession: 'Руководитель IT-проектов',
			},
		],
	},
	{
		number: '11.03.02',
		direction: '11.03.02 Инфокоммуникационные технологии и системы связи',
		contestGroup: 'Инфокоммуникационные технологии и системы связи',
		placeBudget: 69,
		placeContract: 15,
		price: 135000,
		subjectOne: 'Математика',
		subjectTwo: 'Информатика',
		subjectThree: 'Русский язык',
		minPointOne: 50,
		minPointTwo: 50,
		minPointThree: 50,
		pointPreviousYear: 215,
		contestBudget: 38,
		contestContract: 30,
		profession: [
			{
				profession: 'DevOps',
			},
		],
	},
];