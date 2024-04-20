import { Menu, NotebookPen } from 'lucide-react';
import { Link } from 'react-router-dom';
import { Sheet, SheetContent, SheetTrigger } from './ui/sheet';
import { Button } from './ui/button';
import ModeToggle from './ModeToggle';

const Header = () => {
	return (
		<header className="sticky top-0 z-50 w-full flex h-16 items-center md:justify-center gap-4 border-b border-border/40 bg-background/95 backdrop-blur supports-[backdrop-filter]:bg-background/60 px-4 md:px-6">
			<nav className="hidden flex-col gap-6 font-medium md:flex md:flex-row md:items-center md:justify-between w-full md:gap-5 md:text-base lg:gap-6">
				<Link
					to="/"
					className="flex items-center gap-2 font-semibold md:text-base"
				>
					<NotebookPen className="h-6 w-6" />
					<span>Ассистент студента</span>
				</Link>
				<Link
					to="/places"
					className="text-muted-foreground transition-colors hover:text-foreground"
				>
					Места рядом
				</Link>
				<Link
					to="/universities"
					className="text-muted-foreground transition-colors hover:text-foreground"
				>
					Поступление
				</Link>
				<Link
					to="/activities"
					className="text-muted-foreground transition-colors hover:text-foreground"
				>
					Мероприятия
				</Link>
				<Link
					to="/apartments"
					className="text-muted-foreground transition-colors hover:text-foreground"
				>
					Подбор жилья
				</Link>
				<Link
					to="/education"
					className="text-muted-foreground transition-colors hover:text-foreground"
				>
					Подбор программ доп. образования
				</Link>
				<ModeToggle />
			</nav>
			<Sheet>
				<SheetTrigger asChild>
					<Button variant="outline" size="icon" className="shrink-0 md:hidden">
						<Menu className="h-5 w-5" />
						<span className="sr-only">Меню навигации</span>
					</Button>
				</SheetTrigger>
				<SheetContent side="left">
					<nav className="grid gap-6 text-lg font-medium">
						<Link
							to="/"
							className="flex items-center gap-2 text-xl font-semibold"
						>
							<NotebookPen className="h-7 w-7" />
							<span>Ассистент студента</span>
						</Link>
						<Link to="/places" className="text-muted-foreground hover:text-foreground">
							Места рядом
						</Link>
						<Link
							to="/universities"
							className="text-muted-foreground hover:text-foreground"
						>
							Поступление
						</Link>
						<Link
							to="/activities"
							className="text-muted-foreground hover:text-foreground"
						>
							Мероприятия
						</Link>
						<Link
							to="/apartments"
							className="text-muted-foreground hover:text-foreground"
						>
							Подбор жилья
						</Link>
						<Link
							to="/education"
							className="text-muted-foreground hover:text-foreground"
						>
							Подбор программ доп. образования
						</Link>
					</nav>
				</SheetContent>
			</Sheet>
			<span className='ml-auto md:hidden'>
				<ModeToggle />
			</span>
		</header>
	);
};

export default Header;
