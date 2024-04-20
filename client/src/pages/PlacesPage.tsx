import {
	Card,
	CardContent,
	CardDescription,
	CardFooter,
	CardHeader,
	CardTitle,
} from '@/components/ui/card';
import { Input } from '@/components/ui/input';
import { Separator } from '@/components/ui/separator';
import { $axios } from '@/http';
import DefaultLayout from '@/layouts/DefaultLayout';
import { useEffect, useState } from 'react';

const PlacesPage = () => {
	const [cards, setCards] = useState([]);

	useEffect(() => {
		const fetchData = async () => {
			const { data } = await $axios.get('/getAttractions');
			setCards(data);
			console.log(data);
		};

		fetchData();
	}, []);

	return (
		<DefaultLayout>
			<div className="container relative">
				<div className="flex flex-col gap-5">
					<h1 className="mt-5 text-2xl font-bold leading-tight tracking-tighter md:text-4xl">
						Интересные места
					</h1>
					<p className='md:w-1/2'>
						Узнайте о лучших местах в городе для занятий и работы в удобной и
						красивой обстановке. Мы предоставили список мест, которые отличаются
						не только своей привлекательностью, но и обладают такими удобствами,
						как бесплатные точки доступа Wi-Fi, общественные туалеты и ближайшие
						станции метро.
					</p>
					<Input placeholder="Введите свое местоположение..." />
					<Separator />
					<div className="grid gap-4 md:grid-cols-2 md:gap-8 lg:grid-cols-3">
						{cards.map(card => (
							<Card key={card.id} className="hover:cursor-pointer hover:border-blue-300 hover:bg-muted transition-colors duration-300 ease-in-out">
								<CardHeader>
									<CardTitle>{card.beautifulPlace.title} </CardTitle>
									<CardDescription># {card.beautifulPlace.categories[0]} {card.wiFi.length > 0 ? '# Wi-Fi' : ''}</CardDescription>
								</CardHeader>
								<CardContent className='flex flex-col items-center'>
                  <img src={card.beautifulPlace.linkToPhotos[0]} className='object-cover w-1/3 lg:w-2/3 rounded-xl mb-5'/>
									<p>{card.beautifulPlace.description.length > 120 ? `${card.beautifulPlace.description.slice(0, 120)}. . .` : card.beautifulPlace.description}</p>
								</CardContent>
								<CardFooter>
									<p>Адрес: {card.beautifulPlace.address || card.beautifulPlace.district || 'Санкт-Петербург'}</p>
								</CardFooter>
							</Card>
						))}
					</div>
				</div>
			</div>
		</DefaultLayout>
	);
};

export default PlacesPage;
