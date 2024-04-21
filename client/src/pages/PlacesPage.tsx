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
import {
	DropdownMenu,
	DropdownMenuContent,
	DropdownMenuRadioGroup,
	DropdownMenuRadioItem,
	DropdownMenuTrigger,
} from '@/components/ui/dropdown-menu';
import { Input } from '@/components/ui/input';
import { Label } from '@/components/ui/label';
import { Separator } from '@/components/ui/separator';
import { Switch } from '@/components/ui/switch';
import { $axios } from '@/http';
import DefaultLayout from '@/layouts/DefaultLayout';
import { ChevronDown } from 'lucide-react';
import { useEffect, useState } from 'react';
import { MapPin } from 'lucide-react';
import { getYandexRouteLink } from '@/utils/helpers';

const PlacesPage = () => {
	const [page, setPage] = useState(2);
	const [cards, setCards] = useState([]);
	const [curAddress, setCurAddress] = useState(
		'г. Санкт-Петербург, Дворцовая площадь'
	);
	const [curCords, setCurCords] = useState([30.315473, 59.938991]);
	const [wifi, setWifi] = useState(false);
	const [geo, setGeo] = useState(false);
	const [category, setCategory] = useState('');

	useEffect(() => {
		const fetchData = async () => {
			const { data } = await $axios.get(`/getAttractions?page=${1}`);
			setCards(data);
			console.log(data);
		};

		fetchData();
	}, []);

	const fetchMoreData = async () => {
		let url = `/getAttractions?page=${page}`;
		if (wifi) url += '&hasWiFi=1';
		if (geo && curCords.length) {
			url += `&longitude=${curCords[1]}&latitude=${curCords[0]}`;
		}
		if (category) {
			url += `&type=${category}`;
		}

		const { data } = await $axios.get(url);

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
					<div className="grid grid-cols-1 md:grid-cols-2 gap-10">
						<div className="flex flex-col gap-5">
							<p className="">
								Узнайте о лучших местах в городе для занятий и работы в удобной
								и красивой обстановке. Мы предоставили список мест, которые
								отличаются не только своей привлекательностью, но и обладают
								такими удобствами, как бесплатные точки доступа Wi-Fi и
								общественные туалеты.
							</p>
							<div className="flex flex-row gap-4">
								<Input
									className="w-[90%]"
									placeholder="Введите свое местоположение..."
								/>
							</div>
							<Button
								onClick={() => {
									navigator.geolocation.getCurrentPosition(success, error, {
										// высокая точность
										enableHighAccuracy: true,
									});

									async function success({ coords }) {
										// получаем широту и долготу
										const { latitude, longitude } = coords;
										console.log({ latitude, longitude });
										const position = [latitude, longitude];
										setCurCords([longitude, latitude]);

										const { data } = await $axios.get(
											`https://geocode.gate.petersburg.ru/geocode/reverse?x=${longitude}&y=${latitude}`
										);
										console.log(data?.address); // [широта, долгота]
										if (data?.address) {
											setCurAddress(data.address);
										}
									}

									function error({ message }) {
										console.log(message); // при отказе в доступе получаем PositionError: User denied Geolocation
									}
								}}
								className="w-52"
							>
								Определить геолокацию
							</Button>
							<div>
								{' '}
								<span className="font-semibold">
									Текущее местоположение:
								</span>{' '}
								<span className="text-muted-foreground">{curAddress}</span>
							</div>
						</div>
						<div className="flex flex-col gap-5">
							<div className="flex items-center space-x-2">
								<Switch
									id="only-wifi"
									onCheckedChange={() => setWifi(prev => !prev)}
								/>
								<Label htmlFor="only-wifi">Только места с Wi-Fi</Label>
							</div>
							<div className="flex items-center space-x-2">
								<Switch
									id="geo"
									onCheckedChange={() => setGeo(prev => !prev)}
								/>
								<Label htmlFor="geo">Сначала ближайшие</Label>
							</div>
							<DropdownMenu>
								<DropdownMenuTrigger asChild>
									<Button variant="outline" className="md:w-1/2">
										{category || 'Выбрать категорию'}{' '}
										<ChevronDown className="ml-2 h-4 w-4" />
									</Button>
								</DropdownMenuTrigger>
								<DropdownMenuContent className="w-56">
									<DropdownMenuRadioGroup
										value={category}
										onValueChange={setCategory}
									>
										<DropdownMenuRadioItem value="Архитектура">
											Архитектура
										</DropdownMenuRadioItem>
										<DropdownMenuRadioItem value="Природа">
											Природа
										</DropdownMenuRadioItem>
										<DropdownMenuRadioItem value="Развлечения">
											Развлечения
										</DropdownMenuRadioItem>
										<DropdownMenuRadioItem value="Гастрономия">
											Гастрономия
										</DropdownMenuRadioItem>
										<DropdownMenuRadioItem value="Достопримечательность">
											Достопримечательность
										</DropdownMenuRadioItem>
										<DropdownMenuRadioItem value="Музей">
											Музей
										</DropdownMenuRadioItem>
										<DropdownMenuRadioItem value="Театр">
											Театр
										</DropdownMenuRadioItem>
									</DropdownMenuRadioGroup>
								</DropdownMenuContent>
							</DropdownMenu>
							<Button
								className="md:w-1/2"
								disabled={!wifi && !geo && !category}
								onClick={async () => {
									setPage(1);
									let url = `/getAttractions?page=${1}`;
									if (wifi) url += '&hasWiFi=1';
									if (geo && curCords.length) {
										url += `&longitude=${curCords[1]}&latitude=${curCords[0]}`;
									}
									if (category) {
										url += `&type=${category}`;
									}

									const { data } = await $axios.get(url);
									console.log(data);
									setCards(data);
									setPage(prev => prev + 1);
								}}
							>
								Применить фильтры
							</Button>
						</div>
					</div>

					<Separator className="my-8" />
					<div className="grid gap-4 md:grid-cols-2 md:gap-8 lg:grid-cols-3">
						{cards.map(card => (
							<Dialog key={card.id}>
								<DialogTrigger asChild>
									<Card className="hover:cursor-pointer hover:border-blue-300 hover:bg-muted transition-colors duration-300 ease-in-out">
										<CardHeader>
											<CardTitle>{card.beautifulPlace.title} </CardTitle>
											<CardDescription className="flex gap-2 pt-2">
												<Badge variant="secondary">
													#{card.beautifulPlace.categories[0]}{' '}
												</Badge>
												{card.wiFi.length > 0 ? (
													<Badge variant="secondary">#Wi-Fi</Badge>
												) : (
													''
												)}
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
										<DialogDescription className="flex gap-2">
											<Badge variant="secondary">
												#{card.beautifulPlace.categories[0]}
											</Badge>

											{card.wiFi.length > 0 ? (
												<Badge variant="secondary">#Wi-Fi</Badge>
											) : (
												''
											)}
										</DialogDescription>
									</DialogHeader>

									<Separator className="mb-4" />
									<div className="flex flex-col items-center gap-4">
										<div>
											<Carousel className="max-w-[50vw] md:max-w-[20vw]">
												<CarouselContent className="w-full flex content-center items-center">
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
										<p className="md:px-5">{card.beautifulPlace.description}</p>
									</div>

									<Separator className="mb-1" />
									<div className="flex flex-col gap-3">
										{card.wiFi.length > 0 && (
											<div className="md:px-5">
												<div className="font-bold"> Ближайшие Wi-Fi точки</div>
												{card.wiFi.slice(0, 6).map((wifi, indx) => (
													<div key={indx}>
														<a
															href="https://yandex.ru/maps/2/saint-petersburg/?ll=30.316336%2C59.969765&z=14"
															target="_blank"
															className="text-muted-foreground transition-colors hover:text-foreground flex gap-2 mb-1"
														>
															{wifi.address}
															<MapPin className="w-4" />
														</a>
													</div>
												))}
											</div>
										)}

										<div className="md:px-5">
											<div className="font-bold">
												{' '}
												Ближайший общественный туалет{' '}
											</div>
											<a
												href="https://yandex.ru/maps/2/saint-petersburg/?ll=30.316336%2C59.969765&z=14"
												target="_blank"
												className="text-muted-foreground transition-colors hover:text-foreground flex gap-2"
											>
												{card.toilets.address}
												<MapPin className="w-4" />
											</a>
										</div>

										<Separator className="my-2" />

										<div className="text-muted-foreground md:px-5">
											<p className="mb-2 text-muted-foreground">
												Адрес:{' '}
												{card.beautifulPlace.address ||
													card.beautifulPlace.district ||
													'Санкт-Петербург'}
											</p>
											Станция метро "{card.metro.name}"
										</div>
									</div>
									<DialogFooter>
										<div className="flex flex-col gap-2 md:flex-row">
											<div>
												<a
													href={getYandexRouteLink(
														curCords[1],
														curCords[0],
														card.longitude,
														card.latitude
													)}
													target="_blank"
												>
													<Button className="w-full">Построить маршрут</Button>
												</a>
											</div>
											<div>
												<DialogClose asChild>
													<Button
														type="button"
														variant="secondary"
														className="w-full"
													>
														Закрыть
													</Button>
												</DialogClose>
											</div>
										</div>
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
