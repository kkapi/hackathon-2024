import {
	AlertDialog,
	AlertDialogAction,
	AlertDialogCancel,
	AlertDialogContent,
	AlertDialogDescription,
	AlertDialogFooter,
	AlertDialogHeader,
	AlertDialogTitle,
	AlertDialogTrigger,
} from '@/components/ui/alert-dialog';
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
	Carousel,
	CarouselContent,
	CarouselItem,
	CarouselNext,
	CarouselPrevious,
} from '@/components/ui/carousel';
import {
	Dialog,
	DialogClose,
	DialogContent,
	DialogDescription,
	DialogFooter,
	DialogHeader,
	DialogTitle,
	DialogTrigger,
} from '@/components/ui/dialog';
import { Input } from '@/components/ui/input';
import { Separator } from '@/components/ui/separator';
import { $axios } from '@/http';
import DefaultLayout from '@/layouts/DefaultLayout';
import { useEffect, useState } from 'react';

const PlacesPage = () => {
	const [page, setPage] = useState(2);
	const [cards, setCards] = useState([]);

	useEffect(() => {
		const fetchData = async () => {
			const { data } = await $axios.get(`/getAttractions?page=${1}`);
			setCards(data);
			console.log(data);
		};

		fetchData();
	}, []);

	const fetchMoreData = async () => {
		const { data } = await $axios.get(`/getAttractions?page=${page}`);
    
		setCards([...cards, ...data]);
		setPage(prev => prev + 1);
	};

	return (
		<DefaultLayout>
			<div className="container relative">
				<div className="flex flex-col gap-5">
					<h1 className="mt-5 text-2xl font-bold leading-tight tracking-tighter md:text-4xl">
						Интересные места
					</h1>
					<p className="md:w-1/2">
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
							<Dialog key={card.id}>
								<DialogTrigger asChild>
									<Card className="hover:cursor-pointer hover:border-blue-300 hover:bg-muted transition-colors duration-300 ease-in-out">
										<CardHeader>
											<CardTitle>{card.beautifulPlace.title} </CardTitle>
											<CardDescription>
												#{card.beautifulPlace.categories[0]}{' '}
												{card.wiFi.length > 0 ? '#Wi-Fi' : ''}
											</CardDescription>
										</CardHeader>
										<CardContent className="flex flex-row content-center items-start gap-5 md:flex-col md:items-center">
											<img
												src={card.beautifulPlace.linkToPhotos[0]}
												className="object-cover w-1/3 lg:w-2/3 rounded-xl"
											/>
											<p>
												{card.beautifulPlace.description.length > 120
													? `${card.beautifulPlace.description.slice(
															0,
															120
													  )}. . .`
													: card.beautifulPlace.description}
											</p>
										</CardContent>
										<CardFooter>
											<p className="text-sm text-muted-foreground">
												Адрес:{' '}
												{card.beautifulPlace.address ||
													card.beautifulPlace.district ||
													'Санкт-Петербург'}
											</p>
										</CardFooter>
									</Card>
								</DialogTrigger>
								<DialogContent className="sm:max-w-md overflow-y-auto max-h-[90vh] max-w-[90vw] md:max-w-[50vw]">
									<DialogHeader>
										<DialogTitle className="text-xl">
											{card.beautifulPlace.title}
										</DialogTitle>
										<DialogDescription>
											#{card.beautifulPlace.categories[0]}{' '}
											{card.wiFi.length > 0 ? '# Wi-Fi' : ''}
										</DialogDescription>
									</DialogHeader>
									<Separator />
									<div className="flex flex-col items-center gap-4">
										<div>
											<Carousel className="max-w-[50vw] md:max-w-[20vw]">
												<CarouselContent className="w-full">
													{card.beautifulPlace.linkToPhotos.map(
														(img, index) => (
															<CarouselItem key={index}>
																<img
																	src={img}
																	className="object-cover w-full rounded-xl"
																/>
															</CarouselItem>
														)
													)}
												</CarouselContent>
												<CarouselPrevious />
												<CarouselNext />
											</Carousel>
										</div>
										<p className="w-[85%]">{card.beautifulPlace.description}</p>
									</div>
									<Separator />
									<div className="flex flex-col gap-3 ml-5">                    
										{card.wiFi.length > 0 && (
											<div>
												Wi-Fi
												{card.wiFi.map(wifi => (
													<div>
														{wifi.address} {wifi.coordinates.join('')}
														<Button variant="secondary">Построить</Button>
													</div>
												))}
											</div>
										)}

										<div>
											Toilet{' '}
											<div>
												{card.toilets.address}{' '}
												<Button variant="secondary">Построить</Button>
											</div>{' '}
										</div>
									</div>
									<DialogFooter>
										<a href="https://ya.ru/" target="_blank">
											<Button>Построить маршрут</Button>
										</a>
										<DialogClose asChild>
											<Button type="button" variant="secondary">
												Закрыть
											</Button>
										</DialogClose>
									</DialogFooter>
								</DialogContent>
							</Dialog>
						))}
					</div>
					<Button onClick={() => fetchMoreData()}>Получить еще</Button>
				</div>
			</div>
		</DefaultLayout>
	);
};

export default PlacesPage;
