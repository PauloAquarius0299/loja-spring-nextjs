import {
    Command,
    CommandDialog,
    CommandEmpty,
    CommandGroup,
    CommandInput,
    CommandItem,
    CommandList,
    CommandSeparator,
    CommandShortcut,
} from "@/components/ui/command";
import Link from 'next/link';
import { LayoutDashboard, Newspaper, Folders, CreditCard, User, Settings, ChartBarBig } from 'lucide-react';  

const Sidebar = () => {
  return (
    <nav>
      <Command className='bg-secondary rounded-none'>
  <CommandInput placeholder="Pesquise os itens..." />
  <CommandList>
    <CommandEmpty>No results found.</CommandEmpty>
    <CommandGroup heading="Suggestions">
      <CommandItem>
        <LayoutDashboard className="mr-2 h-4 w-4" />
        <Link href='/'> Dashboard</Link>
      </CommandItem>
      <CommandItem>
      <Newspaper className="mr-2 h-4 w-4" />
      <Link href='/posts'> Posts</Link>
      </CommandItem>
      <CommandItem>
      <Folders className="mr-2 h-4 w-4" />
      <Link href='/'> Categories</Link>
      </CommandItem>
      <CommandItem>
      <ChartBarBig className="mr-2 h-4 w-4" />
      <Link href='/estados'>Estados </Link>
      </CommandItem>
    </CommandGroup>
    <CommandSeparator />
    <CommandGroup heading="Settings">
      <CommandItem>
        <User  className="mr-2 h-4 w-4" />
        <span>Perfil</span>
        <CommandShortcut>Adm</CommandShortcut>
      </CommandItem>
      <CommandItem>
        <CreditCard  className="mr-2 h-4 w-4" />
        <span>Creditos</span>
        <CommandShortcut>%B</CommandShortcut>
      </CommandItem>
      <CommandItem>
        <Settings  className="mr-2 h-4 w-4" />
        <span>Configurações</span>
        <CommandShortcut>%C</CommandShortcut>
      </CommandItem>
    </CommandGroup>
  </CommandList>
</Command>

    </nav>
  )
}

export default Sidebar
