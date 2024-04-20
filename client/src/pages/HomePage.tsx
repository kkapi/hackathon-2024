import Balance from 'react-wrap-balancer';

import { cn } from '@/lib/utils';
import Header from '@/components/Header';
import { Button } from '@/components/ui/button';
import { Separator } from '@/components/ui/separator';
import { Card, CardContent, CardHeader, CardTitle } from '@/components/ui/card';
import Footer from '@/components/Footer';

const HomePage = () => {
	return (
		<>
			<Header />
			<div className="container relative">
				<section
					className={cn(
						'mx-auto flex max-w-[980px] flex-col items-center gap-2 py-8 md:py-12 md:pb-8 lg:py-24 lg:pb-20'
					)}
				>
					<h1
						className={cn(
							'text-center text-3xl font-bold leading-tight tracking-tighter md:text-6xl lg:leading-[1.1]'
						)}
					>
						Ассистент студента СПб
					</h1>
					<Balance
						className={cn(
							'max-w-[750px] text-center text-lg text-muted-foreground sm:text-xl'
						)}
					>
						Добро пожаловать на цифровой сервис «Ассистент студента СПб»! Мы
						помогаем формировать рекомендации в сфере образования, науки, досуга
						и быта, чтобы помочь вам лучше управлять своим временем и получать
						максимум удовольствия и пользы от студенческой жизни.
					</Balance>
					<div
						className={cn(
							'flex w-full items-center justify-center space-x-4 py-4 md:pb-10'
						)}
					>
						<Button onClick={() => {}}>Начать</Button>
						<Button variant="outline">GitHub</Button>
					</div>
				</section>

				<Separator />

				<div className="mt-12 grid gap-4 md:grid-cols-2 md:gap-8 lg:grid-cols-2">
					<Card>
						<CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
							<CardTitle className="text-xl font-medium">
								Места рядом
							</CardTitle>
						</CardHeader>
						<CardContent>
							<div className="text-2xl font-bold">$45,231.89</div>
							<p className="text-xs text-muted-foreground">
								+20.1% from last month
							</p>
						</CardContent>
					</Card>
					<Card>
						<CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
							<CardTitle className="text-xl font-medium">
								Поступление
							</CardTitle>
						</CardHeader>
						<CardContent>
							<div className="text-2xl font-bold">+2350</div>
							<p className="text-xs text-muted-foreground">
								+180.1% from last month
							</p>
						</CardContent>
					</Card>					
					<Card>
						<CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
							<CardTitle className="text-xl font-medium">Мероприятия</CardTitle>
						</CardHeader>
						<CardContent>
							<div className="text-2xl font-bold">+573</div>
							<p className="text-xs text-muted-foreground">
								+201 since last hour
							</p>
						</CardContent>
					</Card>
					<Card>
						<CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
							<CardTitle className="text-xl font-medium">Подбор жилья</CardTitle>
						</CardHeader>
						<CardContent>
							<div className="text-2xl font-bold">+573</div>
							<p className="text-xs text-muted-foreground">
								+201 since last hour
							</p>
						</CardContent>
					</Card>
					<Card>
						<CardHeader className="flex flex-row items-center justify-between space-y-0 pb-2">
							<CardTitle className="text-xl font-medium">Подбор программ доп. образования</CardTitle>
						</CardHeader>
						<CardContent>
							<div className="text-2xl font-bold">+573</div>
							<p className="text-xs text-muted-foreground">
								+201 since last hour
							</p>
						</CardContent>
					</Card>
				</div>
			</div>
      <Footer />
		</>
	);
};

export default HomePage;
