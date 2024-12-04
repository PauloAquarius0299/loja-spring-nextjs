import {
    DropdownMenu,
    DropdownMenuContent,
    DropdownMenuItem,
    DropdownMenuLabel,
    DropdownMenuSeparator,
    DropdownMenuTrigger,
  } from "@/components/ui/dropdown-menu"
import Link from "next/link"
import { Avatar, AvatarFallback, AvatarImage } from "./ui/avatar";
  
const Navbar = () => {
  return (
    <header className='bg-primary dark:bg-slate-700 text-white py-2 px-5 flex justify-between'>
        <Link href='/'>
        <h1 className='text-orange-500 text-4xl'>ShopXpress <span className='text-purple-700'>ADM</span></h1>
        </Link>
        
<DropdownMenu>
  <DropdownMenuTrigger className="focus:outline-none">
    <Avatar>
      <AvatarImage src="https://github.com/shadcn.png" />
       <AvatarFallback className='text-black'>ADM</AvatarFallback>
    </Avatar>
   </DropdownMenuTrigger>
   <DropdownMenuContent>
    <DropdownMenuLabel>Minha Conta</DropdownMenuLabel>
    <DropdownMenuSeparator />
    <DropdownMenuItem>Perfil</DropdownMenuItem>
    <DropdownMenuItem>Billing</DropdownMenuItem>
    <DropdownMenuItem>Team</DropdownMenuItem>
    <DropdownMenuItem>Subscription</DropdownMenuItem>
  </DropdownMenuContent>
</DropdownMenu>
    </header>
    
  
  )
}

export default Navbar;
