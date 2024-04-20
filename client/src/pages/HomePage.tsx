import Balance from 'react-wrap-balancer';

import { cn } from '@/lib/utils';
import Header from '@/components/Header';
import { Button } from '@/components/ui/button';
import { Separator } from '@/components/ui/separator';
import { useRef } from 'react';

const HomePage = () => {
  const myRef = useRef(null);

  const scrollToElement = () => {
    myRef.current.scrollIntoView({ behavior: "smooth" });
  };

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
						<Button onClick={scrollToElement}>Начать</Button>
						<Button variant="outline">GitHub</Button>
					</div>
				</section>

				<Separator />

        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div ref={myRef}>AMOGUS</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
        <div>TEST</div>
      
			</div>
		</>
	);
};

export default HomePage;
