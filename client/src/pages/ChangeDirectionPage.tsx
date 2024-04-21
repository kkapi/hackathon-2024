import { Badge } from '@/components/ui/badge';
import { Button } from '@/components/ui/button';
import {
	Card,
	CardContent,
	CardDescription,
	CardFooter,
	CardHeader,
	CardTitle,
} from '@/components/ui/card';
import {
	DropdownMenu,
	DropdownMenuContent,
	DropdownMenuRadioGroup,
	DropdownMenuRadioItem,
	DropdownMenuTrigger,
} from '@/components/ui/dropdown-menu';
import { Separator } from '@/components/ui/separator';
import { $axios } from '@/http';
import DefaultLayout from '@/layouts/DefaultLayout';
import { ChevronDown } from 'lucide-react';
import { useState } from 'react';

const directionsInfo = [
	'45.03.02',
	'11.04.04',
	'27.03.02',
	'27.03.03',
	'27.03.04',
	'27.03.05',
	'42.04.01',
	'12.03.04',
	'28.04.01',
	'09.03.01',
	'12.04.01',
	'13.04.02',
	'04.03.02',
	'38.04.02',
	'11.03.01',
	'11.03.02',
	'15.04.06',
	'20.04.01',
	'11.05.01',
	'09.03.04',
	'45.04.02',
	'09.03.02',
	'01.03.02',
	'11.03.03',
	'11.03.04',
	'27.04.04',
	'27.04.03',
	'27.04.05',
	'12.04.04',
	'27.04.02',
	'09.04.02',
	'38.03.02',
	'09.04.01',
	'12.03.01',
	'13.03.02',
	'42.03.01',
	'28.03.01',
	'15.03.06',
	'11.04.02',
	'11.04.03',
	'01.04.02',
	'04.04.02',
	'11.04.01',
	'10.05.01',
	'20.03.01',
	'09.04.04',
].sort((a, b) => a.localeCompare(b));

const professionInfo = [
	'Data Scientist',
	'BI-аналитик',
	'Бизнес-аналитик',
	'Системный аналитик',
	'Frontend-разработчик',
	'Backend-разработчик',
	'Fullstack-разработчик',
	'Руководитель IT-проектов',
	'DevOps',
	'Тестировщик',
	'Технический писатель',
	'Специалист по информационной безопасности',
	'Системный администратор',
	'Сетевой инженер',
	'Backend -разработчик',
];

const ChangeDirectionPage = () => {
	const [direction, setDirection] = useState('');
	const [profession, setProfession] = useState('');
	const [cards, setCards] = useState([]);

	return (
		<DefaultLayout>
			<div className="container relative min-h-[100vh]">
				<div className="flex flex-col gap-5">
					<h1 className="mt-5 text-2xl font-bold leading-tight tracking-tighter md:text-4xl">
						Смена направления
					</h1>
					<div className="flex flex-col md:flex-row gap-8">
						<p className="md:w-1/2">
							В данном разделе вы сможете найти информацию о подходящих
							программных курсах, учитывая ваши учебные планы и желаемую
							профессию. Выберете ваще текущее направление и желаемую профессию,
							и мы выведем список направлений наиболее совпадающих с вашим
							учебным планом.
						</p>
						<div className="flex flex-col gap-5 md:w-[50vw]">
							<div>
								<DropdownMenu>
									<DropdownMenuTrigger asChild>
										<Button variant="outline" className="md:w-1/2">
											{direction || 'Выбрать направление'}{' '}
											<ChevronDown className="ml-2 h-4 w-4" />
										</Button>
									</DropdownMenuTrigger>
									<DropdownMenuContent className="w-56">
										<DropdownMenuRadioGroup
											value={direction}
											onValueChange={setDirection}
											className="max-h-[200px] overflow-y-auto"
										>
											{directionsInfo.map((direction, id) => (
												<DropdownMenuRadioItem key={id} value={direction}>
													{direction}
												</DropdownMenuRadioItem>
											))}
										</DropdownMenuRadioGroup>
									</DropdownMenuContent>
								</DropdownMenu>
							</div>
							<div>
								<DropdownMenu>
									<DropdownMenuTrigger asChild>
										<Button variant="outline" className="w-1/2">
											{profession || 'Выбрать профессию'}{' '}
											<ChevronDown className="ml-2 h-4 w-4" />
										</Button>
									</DropdownMenuTrigger>
									<DropdownMenuContent className="w-56">
										<DropdownMenuRadioGroup
											value={profession}
											onValueChange={setProfession}
											className="max-h-[200px] overflow-y-auto"
										>
											{professionInfo.map((profession, id) => (
												<DropdownMenuRadioItem key={id} value={profession}>
													{profession}
												</DropdownMenuRadioItem>
											))}
										</DropdownMenuRadioGroup>
									</DropdownMenuContent>
								</DropdownMenu>
							</div>
							<Button
								className="w-1/2"
								onClick={() => {
									if (!profession || !direction) return;
									async function fetchData() {
										const { data } = await $axios.get(
											`/transfer?profession=${profession}&plan=${direction}`
										);
										setCards(data);
										console.log(data);
									}
									fetchData();
								}}
							>
								Получить информацию
							</Button>
						</div>
					</div>
					<Separator className="my-5" />
					{cards.length < 2 && (
						<h1 className="font-bold text-3xl">
							Выберете профессию и направление чтобы получить результат
						</h1>
					)}
					<div className="grid grid-cols-1 md:grid-cols-3 gap-5">
						{cards.slice(1).map(card => (
							<Card
								key={card.number}
								className="hover:border-blue-300 hover:bg-muted transition-colors duration-300 ease-in-out"
							>
								<CardHeader>
									<CardTitle>{card.direction}</CardTitle>
									<CardDescription className="flex gap-2 pt-2">
										Совпадение учебного плана:{' '}
										<Badge>
											{card.countMatches}/{cards[0].countMatches}
										</Badge>
									</CardDescription>
								</CardHeader>
								<CardContent className="flex flex-col gap-3">
									<div>
										Количество бюджетных мест:{' '}
										<span className="font-semibold">{card.placeBudget}</span>
									</div>
									<div>
										Количество контрактных мест:{' '}
										<span className="font-semibold">{card.placeContract}</span>
									</div>
									<div>
										Цена:{' '}
										<sspan className="font-semibold" an>
											{card.price}
										</sspan>
									</div>
								</CardContent>
							</Card>
						))}
					</div>
				</div>
			</div>
		</DefaultLayout>
	);
};

export default ChangeDirectionPage;
