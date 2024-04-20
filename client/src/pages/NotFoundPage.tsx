import { Button } from '@/components/ui/button';
import {
	Card,
	CardDescription,
	CardFooter,
	CardHeader,
	CardTitle,
} from '@/components/ui/card';
import { Link } from 'react-router-dom';

const NotFoundPage = () => {
	return (
		<div className="flex items-center justify-center h-screen bg-background">
			<Card className="w-[420px]">
				<CardHeader className="text-center">
					<CardTitle className="lg:text-7xl text-4xl">404</CardTitle>
					<CardDescription>
						<span className='font-bold text-xl'>Страница не найдена</span>
					</CardDescription>
					<CardDescription>
						Страница, на которую вы пытаетесь попасть, не существует или была
						удалена.
					</CardDescription>
				</CardHeader>
				<CardFooter className="flex justify-center">
					<Button asChild>
						<Link to="/">На главную</Link>
					</Button>
				</CardFooter>
			</Card>
		</div>
	);
};

export default NotFoundPage;
