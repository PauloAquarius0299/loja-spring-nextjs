'use client'
import { Button } from '@/components/ui/button';
import { Search } from 'lucide-react';
import React, { useState } from 'react';

const Estados = () => {
  const [isModalOpen, setIsModalOpen] = useState(false);
  const [estado, setEstado] = useState('');
  const [sigla, setSigla] = useState('');
  const [cadastrados, setCadastrados] = useState<{ estado: string; sigla: string }[]>([]);

  const handleAddEstado = () => {
    if (estado && sigla) {
      setCadastrados((prev) => [...prev, { estado, sigla }]);
      setEstado('');
      setSigla('');
      setIsModalOpen(false); // Fechar modal após adicionar
    }
  };

  return (
    <section className="p-4">
      <div className="flex justify-start py-8 px-8 border-gray border">
        <Button className="bg-green-600" onClick={() => setIsModalOpen(true)}>
          + Novo Estado
        </Button>
      </div>

      {/* Modal */}
      {isModalOpen && (
        <div className="fixed inset-0 flex items-center justify-center bg-black bg-opacity-50 z-50">
          <div className="bg-white p-6 rounded-lg shadow-lg w-[90%] max-w-md">
            <h2 className="text-lg font-bold mb-4">Adicionar Novo Estado</h2>
            <form
              onSubmit={(e) => {
                e.preventDefault();
                handleAddEstado();
              }}
            >
              <div className="mb-4">
                <label className="block text-gray-700 mb-2">Estado:</label>
                <input
                  type="text"
                  value={estado}
                  onChange={(e) => setEstado(e.target.value)}
                  className="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
                />
              </div>
              <div className="mb-4">
                <label className="block text-gray-700 mb-2">Sigla:</label>
                <input
                  type="text"
                  value={sigla}
                  onChange={(e) => setSigla(e.target.value)}
                  className="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
                />
              </div>
              <div className="flex justify-end gap-2">
                <Button
                  className="bg-gray-500"
                  onClick={() => setIsModalOpen(false)}
                  type="button"
                >
                  Cancelar
                </Button>
                <Button className="bg-green-600" type="submit">
                  Salvar
                </Button>
              </div>
            </form>
          </div>
        </div>
      )}

      <div className="flex justify-between py-8 px-8 border-gray border">
        <h2 className="text-2xl text-gray-800">Estados Cadastrados</h2>
        <form className="relative">
          <span className="absolute left-3 top-1/2 -translate-y-1/2 text-gray-400">🔍</span>
          <input
            className="w-full py-2 pl-10 pr-3 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500"
            type="text"
            placeholder="Pesquisar"
          />
        </form>
      </div>
      <div className="px-8">
        {cadastrados.map((item, index) => (
          <div
            key={index}
            className="flex justify-between items-center p-4 border-b last:border-b-0"
          >
            <span>{item.estado}</span>
            <span className="text-gray-600">{item.sigla}</span>
          </div>
        ))}
      </div>
    </section>
  );
};

export default Estados;
